#!/bin/bash

if [ -n "${JAVA_HOME}" ]; then
  RUN="${JAVA_HOME}/bin/java"
else
  if [ `command -v java` ]; then
    RUN="java"
  else
    echo "JAVA_HOME is not set" >&2
    exit 1
  fi
fi

if [[ "$RUN" ]]; then
    version=$("$RUN" -version 2>&1 | awk -F '"' '/version/ {print $2}')
    if [[ "$version" > "1.9" ]]; then
        echo "JAVA version is $version"
    else
        echo "please install JAVA version >= 1.9"
    fi
fi