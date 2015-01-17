FROM tomcat:8-jre7

ADD whisky-app-backend-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/whisky-app.war

# For development use urandom for fast start-up
ENV CATALINA_OPTS "-Djava.security.egd=file:/dev/./urandom"