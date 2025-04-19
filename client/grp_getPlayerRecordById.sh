#!/bin/sh

grpcurl -d '{"id":501}' -plaintext localhost:8088 Player.GetPlayerRecordById