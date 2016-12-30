#!/usr/bin/env bash

mvn clean package
mvn release:clean
mvn -DpushChanges=false -B release:prepare
mvn -DpushChanges=false release:perform
