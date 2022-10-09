# Running App
- mvn clean install

### Start Postgres Database
Run this command with docker desktop app open.
- `docker-compose -p ErrandApp up`

### SonarQube
Generate SonarQube report with code coverage with this command.
NOTE: Sonar Scanner needs to downloaded and added to environment variables (windows) /bash_profile (mac)
- `sonar-scanner`
-  `mvn sonar:sonar -Dsonar.projectKey=sqp_8fc5f6f4f6fde705fa0e6e523a380cdc1d43722b -Dsonar.host.url=http://localhost:9000 -Dsonar.login=392e6dbac47529226c58150337e013ffd2730a8b`

### How to connect to Postgres via Bash
Commands to navigate Postgres Database via command line.
- `docker exec -it shopper-postgresDB bash`
- `psql -U postgres `
- `\l (list DBs)`
- `\c shopper (connect to database)`
- `\d (describe)`