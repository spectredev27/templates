~/1/apache-maven-3.9.9/bin/mvn clean package

if [ -f ~/Projects/tomcat-10.1.33/webapps/springweb.war ]; then
  rm ~/Projects/tomcat-10.1.33/webapps/springweb.war
fi

mv target/springweb.war ~/Projects/tomcat-10.1.33/webapps/springweb.war
~/Projects/tomcat-10.1.33/bin/catalina.sh run
