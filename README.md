# Springboot Security Project with JWT Auth, Swagger with Auth #

## Dependancies used

- Swagger-ui with JWT Authentication
- Flyway database migration
- Postgres SQL database
- Spring Security
- Docker And Docker Compose
- Hybernate

This project demonstrates a springboot project that uses jwt authentication to secure api endpoints
and spring security to check security before any request can be processed. Flyway is used to simplify database management.
Docker and docker compose are used to run the project in managed docker containers. 

## Installing / Getting started

You need to clone the project locally and run the following commands.
```
git clone https://github.com/Farisanipaul/springsecurityjjwt.git

cd springsecurityjjwt

// create a .env file and upload the following

.\mvnw clean package    

```

Format of env file. Update with your custom details.
```
DB_USERNAME=USERNAME
DB_PASSWORD=PASSWORD
DATABASE_NAME=DATABASE_NAME
HOST=HOSTNAME
DB_PORT=EXPOSED_DATABASE_PORT
JWT_SECRET=YOUR_SECRET
JWT_EXPIRY=EXPIRY_MILLISECONDS
```

To run the project use the following command.
```
docker compose up -d --build
```

### Steps to get results

- Register a user 
- Login as the user
- Use the access token to authorize the swagger api
- Check the tests endpoint to verify

Alternatively you can use Postman or Curl to check the api

Please check the following resource to learn more: https://www.javaguides.net/2024/01/spring-boot-security-jwt-tutorial.html

