FROM tomcat:7-jre7
ADD whisky-app-backend-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/whisky-app.war
ENV CATALINA_OPTS="-Djava.security.egd=file:/dev/./urandom"