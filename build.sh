#!/bin/bash

"$(pwd)"/check-java.sh

if [ `command -v mvn` ]; then
  mvn clean package
else
  echo "maven can not be found in PATH, please install maven first" >&2
  exit 1
fi