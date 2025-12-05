import http from "k6/http";
import { check } from "k6";

export const options = {
  discardResponseBodies: true,

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
  check(res, {
    "status is 200": (r) => r.status === 200,
  });
}
