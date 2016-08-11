#!/usr/bin/env bash

mvn clean package
mvn release:clean
mvn -B release:prepare
mvn release:perform