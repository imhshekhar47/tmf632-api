#!/usr/bin/env bash

echo "Starting MySQL database"
read -p "MYSQL_ROOT_PASSWORD:": root_pwd
read -p "MYSQL_USER:": custom_user
read -p "MYSQL_PASSWORD:": custom_pwd
read -p "MYSQL_DATABASE:": custom_db

echo "Launching database '${custom_db}' with credentials '${custom_user}/${custom_pwd}'"
winpty docker run --rm -it \
  -p 3306:3306 \
  -e MYSQL_ROOT_PASSWORD="${root_pwd:-s3kr3t}" \
  -e MYSQL_USER="${custom_user:-tmf632user}" \
  -e MYSQL_PASSWORD="${custom_pwd:-P455w0rd}" \
  -e MYSQL_DATABASE="${custom_db:-tmf632-db}" \
  mysql:latest mysqld --default-authentication-plugin=mysql_native_password