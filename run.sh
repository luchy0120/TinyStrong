#!/bin/bash

. "$(pwd)"/check-java.sh

TARGET_DIR="$(pwd)"/target

if [ -e "$TARGET_DIR"/TinyStrong-[0-9].[0-9]-jar-with-dependencies.jar ]; then
  exec "$RUN" -jar "$TARGET_DIR"/TinyStrong-[0-9].[0-9]-jar-with-dependencies.jar
else
  echo "runnable jar is not found under target directory" >&2
  exit 1
fi