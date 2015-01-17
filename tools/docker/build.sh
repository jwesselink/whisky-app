#!/bin/bash

cp ../../backend/target/whisky-app-backend-1.0-SNAPSHOT.war .
docker build -t repsaj/whisky-app .
rm whisky-app-backend-1.0-SNAPSHOT.war