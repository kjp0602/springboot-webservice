#!/bin/bash
REPOSITORY=/home/ec2-user/app/step2
PROJECT_NAME=springboot-webservice

echo "> File Copy"

cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "> Running Application PID Check"

CURRENT_PID=$(pgrep -fl ${PROJECT_NAME} | grep jar | awk '{print $1}')

echo "Now Running Application PID: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
        echo "> NOT Running APPlication"
        kill -15 $CURRENT_PID
        sleep 5
fi
echo "> New Application Deployed"

JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)
echo " JAR Name: $JAR_NAME"
echo "> JAR_NAME chmod 실행권한 설정"
chmod +x $JAR_NAME
echo "> JAR_NAME 실행"
nohup java -jar \
        -Dspring.config.location=classpath:/application.properties,classpath:/application-real.properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties \
        -Dspring.profiles.active=real \
        $JAR_NAME > $REPOSITORY/nohup.out 2>&1 &