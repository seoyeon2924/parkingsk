FROM openjdk:11-jdk
VOLUME /tmp
ADD target/parkingsk-parkinglot-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
#ADD src/main/resources/scouter/scouter.agent.jar scouter.agent.jar
#ADD src/main/resources/scouter/scouter.conf scouter.conf
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dscouter.config=/scouter.conf","-javaagent:/scouter.agent.jar","-jar","/app.jar"]
# ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
