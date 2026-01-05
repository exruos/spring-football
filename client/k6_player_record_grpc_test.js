import grpc from "k6/net/grpc";
import { check } from "k6";

// Iterations: 36k
export const options = {
  discardResponseBodies: true,

  scenarios: {
    match: {
      executor: "shared-iterations",
      vus: 10,
      iterations: 10,
      maxDuration: "5m",
    },
  },
};

// Initialize the gRPC client
const client = new grpc.Client();
client.load(["../src/main/proto"], "player.proto");

export default function () {
  client.connect("localhost:8088", { plaintext: true });

  const randomId = Math.floor(Math.random() * 11075) + 1;

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
