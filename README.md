# Running App
- mvn clean install

### Start Postgres Database
Run this command with docker desktop app open.
- `docker-compose up`

### SonarQube
Run this command to start SonarQube server if the container does not exist.
- `docker run -d --name sonarqube -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true -p 9000:9000 sonarqube:8.9-community`

To start sonarqube server if the container already exists: `docker start sonarqube`\
To stop sonarqube server if the container already exists: `docker stop sonarqube`

- `mvn sonar:sonar -Dsonar.host.url=http://localhost:9000 -Dsonar.login=sqp_8fc5f6f4f6fde705fa0e6e523a380cdc1d43722b`
Generate SonarQube report with code coverage with this command.
-  `mvn sonar:sonar -Dsonar.projectKey=sqp_8fc5f6f4f6fde705fa0e6e523a380cdc1d43722b -Dsonar.host.url=http://localhost:9000 -Dsonar.login=392e6dbac47529226c58150337e013ffd2730a8b`

### How to connect to Postgres via Bash
Commands to navigate Postgres Database via command line.
- docker exec -it shopper-postgresDB bash`
- `psql -U postgres `
- `\l (list DBs)`
- `\c shopper (connect to database)`
- `\d (describe)`