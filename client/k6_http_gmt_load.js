import http from "k6/http";
import {check} from "k6";

export const options = {
    discardResponseBodies: true,

    // Constant load of 400 iterations per second for 60s
    // ~24k requests in total
    scenarios: {
        player: {
            executor: "per-vu-iterations",
            vus: 100,
            iterations: 200,
            maxDuration: "5m",
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
    check(res, {
        "status is 200": (r) => r.status === 200,
    });
}
