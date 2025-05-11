import http from "k6/http";
import {check} from "k6";

export const options = {
    discardResponseBodies: true,

    // Constant load of 400 iterations per second for 60s
    // ~24k requests in total
    scenarios: {
        player: {
            executor: "constant-vus",
            duration: "5m",
            vus: 100,
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
