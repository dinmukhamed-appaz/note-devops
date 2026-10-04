#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")/.."

export PORT="${PORT:-8080}"

if command -v mvn >/dev/null 2>&1; then MVN=mvn; else MVN=./mvnw; fi

exec "$MVN" -q spring-boot:run