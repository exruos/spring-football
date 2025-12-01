#!/bin/bash
set -euo pipefail

GMT_PATH=$HOME/green-metrics-tool

NAME="Spring Clean Football - REST player with HTTP/2 (k6)"
FILENAME="usage_scenario-k6-player-rest-http2.yml"
URI="$PWD"

cd $GMT_PATH
source venv/bin/activate
python3 runner.py --name "$NAME" --uri "$URI" --filename "$FILENAME" --skip-system-checks --dev-no-optimizations --skip-unsafe
