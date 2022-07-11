# spring-boot-nats
- Nats Version: 2.8.4
- Docker
- Spring Boot
- ReactJs
- Vite
  

## Create a NATS docker
    docker build -t nats-image .
    docker run -d --name nats --network nats -p 4222:4222 -p 8222:8222 -p 443:443 nats-image


## Run backend
    cd demo
    mvn spring-boot:run


## Run frontend
    cd front
    npm install
    npm run dev
    http://localhost:3000/

## Publish message
    GET: http://localhost:8080/nats
After executing a URL, you can view the NATS messages on the interface