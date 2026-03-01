import http from "k6/http";
import { check } from "k6";

export const options = {
  discardResponseBodies: true,

  // Ramp-up to 400 iterations per second in 30s
  // ~6k requests in total
  scenarios: {
    match_by_team: {
      executor: "ramping-arrival-rate",
      startRate: 1,
      timeUnit: "1s",
      preAllocatedVUs: 60,
      stages: [{ target: 400, duration: "30s" }],
    },
  },
};

export default function () {
  const hostname = `${__ENV.TARGET_HOSTNAME}`;
  const port = `${__ENV.TARGET_PORT}`;
  const randomId = Math.floor(Math.random() * 51606) + 1;

  const res = http.get(`http://${hostname}:${port}/match/team/${randomId}`, {
    tags: { name: "match_by_team" },
  });
  check(res, {
    "status is 200": (r) => r.status === 200,
  });
}