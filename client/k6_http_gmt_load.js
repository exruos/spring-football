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
    const hostname = `localhost`;
    const randomId = Math.floor(Math.random() * 11075) + 1;

    const res = http.get(`http://${hostname}:8088/players/record/${randomId}`, {
        tags: {name: "player_record"},
    });
    check(res, {
        "status is 200": (r) => r.status === 200,
    });
}
