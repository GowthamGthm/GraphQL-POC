************************************************************************************************************************************
*									Sample GraphQL applicaiton																								*
************************************************************************************************************************************
1. This application is developed as POC to show how we can use GraphQL  
2. Prerequiste: You will Need Java 8, Spring Boot 2+ and maven to run this application
3. GraphQL tools, GraphiQL and GraphQL java is used
4. Inmemory database H2 is used for POC
5. Build this applicaiton using mvn clean install 
6. To start the application simply Run Application.java
7. Application class loads dummy data in H2
8. Following SDL files used for this demo  root.graphqls, policy.graphqls, claim.graphqls
9. RootQueryHandler handles Queries in root.graphqls
10. PolicyQueryhandler handles extended Queries in policy.graphqls
11. ClaimQueryHandler handles extended Queries in claims.graphqls
12. After starting application we can either use http://localhost:8080 to fire all GraphQL query or Postman
14. http://localhost:8080 launches UI provided by GraphiQL, in this project servlet for grphiql is loaded on default port.
15. It might be worth to route graphiql servlet to separate path

Hope all Infos above is good enough to start
**********************************Happy learning***************************************************************************************
