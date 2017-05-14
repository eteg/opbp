FROM openjdk:8

# Instalação do docker
RUN apt-get install -y apt-transport-https ca-certificates curl software-properties-common
RUN sh -c 'curl -fsSL https://download.docker.com/linux/ubuntu/gpg | apt-key add -'
RUN apt-key fingerprint 0EBFCD88
RUN add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu trusty stable"
RUN apt-get update
RUN apt-get install -y docker-ce

# Executa a build
VOLUME /build
ADD . .
RUN chmod +x gradlew
RUN ./gradlew build buildDocker