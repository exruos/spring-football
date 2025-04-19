#!/bin/sh

grpcurl -d '{"id":1}' -plaintext localhost:8088 Player.GetPlayerById