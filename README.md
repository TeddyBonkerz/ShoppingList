# Running App
- mvn clean install

### Start Postgres Database
Run this command with docker desktop app open.
- `docker-compose -p ErrandApp up`

### SonarQube 
Generate SonarQube report with code coverage with this command at [http://localhost:9000/dashboard](http://localhost:9000/dashboard).
- `mvn sonar:sonar`

### How to connect to Postgres via Bash
Commands to navigate Postgres Database via command line.
- `docker exec -it shopper-postgresDB bash`
- `psql -U postgres `
- `\l (list DBs)`
- `\c shopper (connect to database)`
- `\d (describe)`