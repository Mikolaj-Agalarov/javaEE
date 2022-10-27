docker run --rm `
    --name tomcat `
    -p 8080:8080 `
    --network demo_network `
    -v "D:\JavaEE\Lesson22\target\demo-servlet-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/servlet.war" `
    tomcat:9.0.53-jdk11-openjdk


docker build -t "managed-tomcat" -f Lesson23/Dockerfile-tomcat-manager  .
-v "D:\JavaEE\Lesson23\target\Lesson23-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/servlet.war" `



docker run --rm `
    --name custom-tomcat `
    -p 8080:8080 `
    --network demo_network `
    -v "D:\JavaEE\Lesson23\target\Lesson23-1.0-SNAPSHOT.war:/usr/local/tomcat/webapps/servlet.war" `
    custom-tomcat:latest `

