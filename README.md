# Running App
- mvn clean install

### Start Postgres Database and Sonar Server
Run this command with docker desktop app open.
- `docker-compose -p ErrandApp up`
NOTE: For Windows Users, add `.wslconfig` file in root directory to you `C:\Users\<UserName>\` directory
to fix `max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144]` error when trying
to start Sonar Server with docker-compose.yaml.

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