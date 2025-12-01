import grpc from "k6/net/grpc";
import { check } from "k6";

// Iterations: 36k
export const options = {
  discardResponseBodies: true,

  scenarios: {
    player: {
      executor: "ramping-arrival-rate",

      // Start iterations per `timeUnit`
      startRate: 1,

      // Start `startRate` iterations per second
      timeUnit: "1s",

      // Pre-allocate necessary VUs.
      preAllocatedVUs: 150,

      stages: [
        // Ramp-up to 400 iterations per second
        { target: 400, duration: "30s" },

        // Continue starting 400 iterations per second for one minute.
        { target: 400, duration: "1m" },

        // Linearly ramp-down to starting 1 iteration per second.
        { target: 1, duration: "30s" },
      ],
    },
  },
};

// Initialize the gRPC client
const client = new grpc.Client();
client.load(["../src/main/proto"], "player.proto");

export default function () {
  client.connect("localhost:8088", { plaintext: true });

  const randomId = Math.floor(Math.random() * 11075) + 1;

  // Get player
  const res1 = client.invoke(
    "Player/GetPlayerById",
    {
      id: randomId,
    },
    {
      tags: { name: "GetPlayerById" },
    }
  );
  check(res1, {
    "status is OK": (r) => r && r.status === grpc.StatusOK,
    "protocol is HTTP/2": (r) => r.proto === 'HTTP/2.0',
  });

  // Get player record
  const res2 = client.invoke(
    "Player/GetPlayerRecordById",
    {
      id: randomId,
    },
    {
      tags: { name: "GetPlayerRecordById" },
    }
  );
  check(res2, {
    "status is OK": (r) => r && r.status === grpc.StatusOK,
    "protocol is HTTP/2": (r) => r.proto === 'HTTP/2.0',
  });

  client.close();
}
