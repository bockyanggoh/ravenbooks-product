#!/usr/bin/env bash

function run_dependency() {
  # Dependencies must fit the pattern of [dependency-name]/docker-compose.yml
  echo "Running docker-compose for $1"
  docker-compose -f $1/docker-compose.yml up -d
  if [[ $? != 0 ]];
  then
    echo "Failed to execute docker-compose. Error code is [$?]"
    return $?
  fi
}

run_dependency "kafka"
run_dependency "mysql"