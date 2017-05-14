FROM openjdk:8

# Instalação do nodejs
RUN sh -c 'curl -sL https://deb.nodesource.com/setup_7.x | bash -'
RUN apt-get install -y nodejs
RUN alias node='nodejs'

# Instalação do yarn
RUN sh -c 'curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add -'
RUN echo "deb https://dl.yarnpkg.com/debian/ stable main" | tee /etc/apt/sources.list.d/yarn.list
RUN apt-get update && apt-get install -y yarn

# Instalação do docker
RUN apt-get install apt-transport-https ca-certificates curl software-properties-common
RUN sh -c 'curl -fsSL https://download.docker.com/linux/ubuntu/gpg | apt-key add -'
RUN apt-key fingerprint 0EBFCD88
RUN add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
RUN apt-get update
RUN apt-get install docker-ce

VOLUME /build
ADD . .
RUN chmod +x gradlew
RUN ./gradlew build buildDocker