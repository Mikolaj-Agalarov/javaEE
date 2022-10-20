docker run --rm `
    --name tomcat `
    -p 8080:8080 `
    --network demo_network `
    -v "C:\\untitled1\target\demo-servlet-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/servlet.war" `
    tomcat:9.0.53-jdk11-openjdk