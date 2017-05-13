FROM openjdk:8
RUN sh -c 'chmod +x gradlew'
RUN sh -c './gradlew build buildDocker'