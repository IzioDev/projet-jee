#!/bin/sh

docker run --rm --name=db_jee -p 3306:3306 -v /home/docker/mysql-jee-data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=password -d mysql:5.7
