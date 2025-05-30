import http from "k6/http";
import {check} from "k6";

export const options = {
    batchPerHost: 2,
    discardResponseBodies: true,

    // Constant load of 400 iterations per second for 60s
    // ~24k requests in total
    scenarios: {
        player: {
            executor: "shared-iterations",
            vus: 60,
            iterations: 3000,
            maxDuration: "5m",
        },
    },
};

export default function () {
    const hostname = `${__ENV.TARGET_HOSTNAME}`;
    const port = `${__ENV.TARGET_PORT}`;
    const randomId = []
    const request = []
    for (let i = 0; i < options.batchPerHost; i++) {
        randomId[i] = Math.floor(Math.random() * 11075) + 1;
        request[i] = ['GET', `http://${hostname}:${port}/players/record/${randomId[i]}`, { tags: {name: "player_record"}}]
    }

    const responses = http.batch(request)

    for (let i = 0; i < options.batchPerHost; i++) {
        check(responses[i], {
            "status is 200": (response) => response.status === 200,
        });
    }
}
