import grpc from "k6/net/grpc";
import { check } from "k6";
import { Trend, Counter, Rate } from "k6/metrics";

// Custom Metrics
const playerGrpcDuration = new Trend("player_grpc_duration");
const playerGrpcCount = new Counter("player_grpc_count");
const playerGrpcSuccess = new Rate("player_grpc_success");

export const options = {
  discardResponseBodies: true,

  // Thresholds
  thresholds: {
    'player_grpc_duration': ['p(95)<500', 'p(99)<1000'],
    'player_grpc_success': ['rate>0.99'],
    'grpc_req_duration': ['p(95)<500', 'p(99)<1000'],
  },

  // Constant load of 400 iterations per second for 60s
  // ~24k requests in total
  scenarios: {
    player: {
      executor: "shared-iterations",
      vus: 60,
      iterations: 6000,
      maxDuration: "5m",
    },
  },
};

const client = new grpc.Client();
client.load(["../src/main/proto"], "player.proto");

// Track connection state per VU to avoid reconnecting on every iteration
let isConnected = false;

export default function () {
  // Connect once per VU, reuse connection across all iterations
  if (!isConnected) {
    const hostname = `${__ENV.TARGET_HOSTNAME}`;
    const port = `${__ENV.TARGET_PORT}`;
    client.connect(`${hostname}:${port}`);
    isConnected = true;
  }

  const randomId = Math.floor(Math.random() * 11075) + 1;

  const startTime = Date.now();
  const res = client.invoke(
    "Player/GetPlayerRecordById",
    {
      id: randomId,
    },
    {
      tags: { name: "GetPlayerRecordById" },
    }
  );
  const duration = Date.now() - startTime;

  // Record custom metrics
  playerGrpcDuration.add(duration);
  playerGrpcCount.add(1);
  playerGrpcSuccess.add(res && res.status === grpc.StatusOK);

  check(res, {
    "status is OK": (r) => r && r.status === grpc.StatusOK,
  });

  // Keep connection open for reuse - no close() call
}

