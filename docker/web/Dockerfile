FROM tomcat:10.1-jdk17

COPY tomcat-users.xml $CATALINA_HOME/conf/tomcat-users.xml
COPY context.xml /tmp/context.xml
EXPOSE 8080

RUN mv /usr/local/tomcat/webapps /usr/local/tomcat/webapps2; mv /usr/local/tomcat/webapps.dist /usr/local/tomcat/webapps; cp /tmp/context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml;

COPY smarthome.war /usr/local/tomcat/webapps/smarthome.war

CMD ["catalina.sh", "run"]