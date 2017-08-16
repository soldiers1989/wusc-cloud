FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /ext/tmp
ADD sms-1.0.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
