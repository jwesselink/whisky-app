#!/bin/bash

docker stop whisky-app
docker rm whisky-app
docker run -p 8888:8080 --name whisky-app -d repsaj/whisky-app