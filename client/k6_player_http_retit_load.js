import http from "k6/http";
import {check} from "k6";
import {Trend, Counter, Rate} from "k6/metrics";

// Custom Metrics
const playerRecordDuration = new Trend("player_record_duration");
const playerRecordCount = new Counter("player_record_count");
const playerRecordSuccess = new Rate("player_record_success");

export const options = {
    discardResponseBodies: true,

    // Thresholds
    thresholds: {
        'player_record_duration': ['p(95)<500', 'p(99)<1000'],
        'player_record_success': ['rate>0.99'],
        'http_req_duration': ['p(95)<500', 'p(99)<1000'],
        'http_req_failed': ['rate<0.01'],
    },

    // Constant load of 400 iterations per second for 60s
    // ~24k requests in total
    scenarios: {
        player: {
            executor: "constant-arrival-rate",
            rate: 20,               // 10 requests per second
            timeUnit: "1s",         // per second
            duration: "5m",         // run for 5 minutes
            preAllocatedVUs: 50,    // initial VUs allocated
            maxVUs: 200,            // max VUs if needed
        },
    },
};

export default function () {
    const hostname = `${__ENV.TARGET_HOSTNAME}`;
    const port = `${__ENV.TARGET_PORT}`;
    const randomId = Math.floor(Math.random() * 11075) + 1;

    const res = http.get(`http://${hostname}:${port}/players/record/${randomId}`, {
        tags: {name: "player_record"},
    });

    // Record custom metrics
    playerRecordDuration.add(res.timings.duration);
    playerRecordCount.add(1);
    playerRecordSuccess.add(res.status === 200);

    check(res, {
        "status is 200": (r) => r.status === 200,
    });
}

