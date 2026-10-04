#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")/.."

export PORT="${PORT:-8080}"

./mvnw -q -DskipTests package
exec java -jar target/*.jar