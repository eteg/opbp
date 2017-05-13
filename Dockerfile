FROM openjdk:8
VOLUME /build
ADD .
RUN chmod +x gradlew
RUN ./gradlew build buildDocker