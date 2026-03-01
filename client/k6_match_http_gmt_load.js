import http from "k6/http";
import { check } from "k6";
import { Trend, Counter, Rate } from "k6/metrics";

// Custom Metrics
const matchDuration = new Trend("match_duration");
const matchCount = new Counter("match_count");
const matchSuccess = new Rate("match_success");

export const options = {
  discardResponseBodies: true,

  // Thresholds
  thresholds: {
    'match_duration': ['p(95)<500', 'p(99)<1000'],
    'match_success': ['rate>0.99'],
    'http_req_duration': ['p(95)<500', 'p(99)<1000'],
    'http_req_failed': ['rate<0.01'],
  },

  // Constant load of 400 iterations per second for 60s
  // ~24k requests in total
  scenarios: {
    match: {
      executor: "shared-iterations",
      vus: 60,
      iterations: 6000,
      maxDuration: "5m",
    },
  },
};

export default function () {
  const hostname = `${__ENV.TARGET_HOSTNAME}`;
  const port = `${__ENV.TARGET_PORT}`;
  const randomId = Math.floor(Math.random() * 25979) + 1;

  const res = http.get(`http://${hostname}:${port}/match/${randomId}`, {
    tags: { name: "match" },
  });

  // Record custom metrics
  matchDuration.add(res.timings.duration);
  matchCount.add(1);
  matchSuccess.add(res.status === 200);

  check(res, {
    "status is 200": (r) => r.status === 200,
  });
}

