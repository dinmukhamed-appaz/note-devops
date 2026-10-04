#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")/.."

rm -rf target/surefire-reports

if command -v mvn >/dev/null 2>&1; then MVN=mvn; else MVN=./mvnw; fi

"$MVN" -q test

total=$(grep -h "Tests run:" target/surefire-reports/*.txt | awk -F'[:,]' '{s+=$2} END{print s}')
echo "TESTS: ${total}/${total}"