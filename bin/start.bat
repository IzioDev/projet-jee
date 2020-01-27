docker run --rm --name=db_jee -p 3306:3306 -v ~/mysql-jee-data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=api -d mysql:5.7
