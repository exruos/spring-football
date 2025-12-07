import http from "k6/http";
import { check } from "k6";
import { Trend, Counter, Rate } from "k6/metrics";

// Custom Metrics
const matchByTeamDuration = new Trend("match_by_team_duration");
const matchByTeamCount = new Counter("match_by_team_count");
const matchByTeamSuccess = new Rate("match_by_team_success");

export const options = {
  discardResponseBodies: true,

  // Thresholds
  thresholds: {
    'match_by_team_duration': ['p(95)<500', 'p(99)<1000'],
    'match_by_team_success': ['rate>0.99'],
    'http_req_duration': ['p(95)<500', 'p(99)<1000'],
    'http_req_failed': ['rate<0.01'],
  },

  // Constant load of 400 iterations per second for 60s
  // ~24k requests in total
  scenarios: {
    match_by_team: {
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
  const randomId = Math.floor(Math.random() * 51606) + 1;

  const res = http.get(`http://${hostname}:${port}/match/team/${randomId}`, {
    tags: { name: "match_by_team" },
  });

  // Record custom metrics
  matchByTeamDuration.add(res.timings.duration);
  matchByTeamCount.add(1);
  matchByTeamSuccess.add(res.status === 200);

  check(res, {
    "status is 200": (r) => r.status === 200,
  });
}