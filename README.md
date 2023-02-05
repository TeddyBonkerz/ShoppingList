# Building App
- `mvn clean install`

## Start Postgres Database and Sonar Server
Run this command with docker desktop app open.
- `docker-compose -p ErrandApp up`
NOTE: For Windows Users, add `.wslconfig` file in root directory to you `C:\Users\<UserName>\` directory
to fix `max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144]` error when trying
to start Sonar Server with docker-compose.yaml.

## SonarQube 
### NOTE: This is the step to follow on first use on a machine
Sonarqube Dashboard: [http://localhost:9000/dashboard](http://localhost:9000/dashboard)
On your first run, navigate to url and you will be instructed to create a new password.
Afterwards, navigate to My Account > Security and generate a token.
Place token in pom.xml in properties tag `<sonar.login>...</sonar.login>`.
Afterwards, run `mvn sonar:sonar` in terminal to add project to Sonarqube and generate a reports.

## How to connect to Postgres via Bash
Commands to navigate Postgres Database via command line.
- `docker exec -it shopper-postgresDB bash`
- `psql -U postgres `
- `\l (list DBs)`
- `\c shopper (connect to database)`
- `\d (describe)`
- `\dt (list all tables`

## Swagger Docs
`http://localhost:8080/swagger-ui/index.html`