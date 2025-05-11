import http from "k6/http";
import { check } from "k6";

export const options = {
  discardResponseBodies: true,

  // Ramp-up to 400 iterations per second in 30s
  // ~6k requests in total
  scenarios: {
    player: {
      executor: "ramping-arrival-rate",
      startRate: 1,
      timeUnit: "1s",
      preAllocatedVUs: 100,
      stages: [{ target: 400, duration: "30s" }],
    },
  },
};

export default function () {
  const hostname = `${__ENV.TARGET_HOSTNAME}`;
  const randomId = Math.floor(Math.random() * 11075) + 1;

  const res = http.get(`http://${hostname}/players/record/${randomId}`, {
    tags: { name: "player_record" },
  });
  check(res, {
    "status is 200": (r) => r.status === 200,
  });
}
