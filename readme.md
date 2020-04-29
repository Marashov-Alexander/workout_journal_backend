# Local Deployment

## Run using docker-compose

```bash
docker-compose build
docker-compose up -d workout-journal-mysql-db
```
Wait some seconds until MySQL DB to start.
```bash
docker-compose up -d workout-journal-rest-api-app
```

## API documentation address
Go to this address and press "Show/hide" button:
```bash
http://localhost:8080/swagger-ui.html
```
