FROM tomcat:9.0.64-jre8-temurin
COPY target/parseSql.war /usr/local/tomcat/webapps
CMD ['sh /usr/local/tomcat/starup.sh']