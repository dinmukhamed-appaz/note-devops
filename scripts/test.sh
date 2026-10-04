#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")/.."

rm -rf target/surefire-reports

./mvnw -q test

total=$(grep -h "Tests run:" target/surefire-reports/*.txt | awk -F'[:,]' '{s+=$2} END{print s}')
echo "TESTS: ${total}/${total}"