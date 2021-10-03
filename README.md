## Asset Manager
  A simple app to track and maintain assets.

To run the server, cd into the `server` folder and run:
 
```bash
./mvnw spring-boot:run
```

To run the client, cd into the `client` folder and run:
 
```bash
yarn && yarn start
```

To enable dubugging in Idea, add this to command line argument in the run configurations

```bash
spring-boot:run -Dspring-boot.run.fork=false -f pom.xml
```
