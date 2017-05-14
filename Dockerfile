FROM openjdk:8

# Instalação do docker
RUN apt-get update
RUN apt-get install -y apt-transport-https ca-certificates curl software-properties-common
RUN sh -c 'curl -fsSL https://download.docker.com/linux/ubuntu/gpg | apt-key add -'
RUN apt-key fingerprint 0EBFCD88
RUN add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu trusty stable"
RUN apt-get update
RUN apt-get install -y docker-ce

# Instalação do nodejs
RUN sh -c 'curl -sL https://deb.nodesource.com/setup_7.x | bash -'
RUN apt-get install -y nodejs
RUN alias node='nodejs'

# Instalação do yarn
RUN sh -c 'curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add -'
RUN echo "deb https://dl.yarnpkg.com/debian/ stable main" | tee /etc/apt/sources.list.d/yarn.list
RUN apt-get update && apt-get install -y yarn

# Instalação do gradle
ENV GRADLE_VERSION 3.3
ENV GRADLE_SHA c58650c278d8cf0696cab65108ae3c8d95eea9c1938e0eb8b997095d5ca9a292

RUN cd /usr/lib
RUN curl -fl https://downloads.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip -o gradle-bin.zip
RUN echo "$GRADLE_SHA gradle-bin.zip" | sha256sum -c -
RUN unzip "gradle-bin.zip"
RUN ln -s "/usr/lib/gradle-${GRADLE_VERSION}/bin/gradle" /usr/bin/gradle
RUN rm "gradle-bin.zip"
 
ENV GRADLE_HOME /usr/lib/gradle
ENV PATH $PATH:$GRADLE_HOME/bin

# Executa a build
VOLUME /build
ADD . .
RUN gradle build buildDocker --stacktrace