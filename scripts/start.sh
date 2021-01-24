#!/usr/bin/env bash

ABSPATH=$(readlink -f $0)
ABSDIR=$(dirname $ABSPATH)
source ${ABSDIR}/profile.sh

REPOSITORY=/home/ec2-user/app/step3
PROJCET_NAME=springboot-webservice

cp $REPOSITORY/zip/*.jar $REPOSITORY/

JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tral -n 1)

chmod +x $JAR_NAME

IDLE_PROFILE=$(find_idle_profile)

nohup java -jar \
  -Dspring.config.location=classpath:/application.properties,classpath:/application-$IDLE_PROFILE.properties,/home/etc2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties \
  -Dspring.profiles.active=$IDLE_PROFILE \
  $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &