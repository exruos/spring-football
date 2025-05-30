import grpc from "k6/net/grpc";
import { check } from "k6";

export const options = {
  discardResponseBodies: true,

  // Ramp-up to 400 iterations per second in 30s
  // ~6000 requests in total
  scenarios: {
    player: {
      executor: "ramping-arrival-rate",
      startRate: 1,
      timeUnit: "1s",
      preAllocatedVUs: 60,
      stages: [{ target: 400, duration: "30s" }],
    },
  },
};

const client = new grpc.Client();
client.load(["../src/main/proto"], "player.proto");

export default function () {
  const hostname = `${__ENV.TARGET_HOSTNAME}`;
  const port = `${__ENV.TARGET_PORT}`;
  client.connect(`${hostname}:${port}`, {
    plaintext: true,
  });

  const randomId = Math.floor(Math.random() * 11075) + 1;

  const res = client.invoke(
    "Player/GetPlayerRecordById",
    {
      id: randomId,
    },
    {
      tags: { name: "GetPlayerRecordById" },
    }
  );
  check(res, {
    "status is OK": (r) => r && r.status === grpc.StatusOK,
  });

  client.close();
}
