#!/bin/bash

scala_vers=(2.11 2.12)
json4s_vers=(3.2 3.5 3.6)

for scala_ver in "${scala_vers[@]}"; do
  for json4s_ver in "${json4s_vers[@]}"; do
    echo ""
    echo "============== Scala ${scala_ver} + Json4s ${json4s_ver} =================="
    echo ""

    mvn clean test -P scala_${scala_ver} -P json4s_${json4s_ver}

    if [ $? -eq 1 ]; then
      exit 1
    fi
  done
done
