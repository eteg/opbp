FROM gradle:jdk8

USER root
RUN cd /tmp

# Instalação do nodejs
RUN sh -c 'curl -sL https://deb.nodesource.com/setup_7.x | bash -' \
	&& apt-get install -y nodejs \
	&& alias node='nodejs'

# Instalação do yarn
RUN sh -c 'curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add -' \
	&& echo "deb https://dl.yarnpkg.com/debian/ stable main" | tee /etc/apt/sources.list.d/yarn.list \
	&& apt-get update \ 
	&& apt-get install -y yarn

# Executa a build

# Otimização: Resolve primeiramente as dependencias para criar um layer com elas
VOLUME /build
ADD build.gradle settings.gradle ./
ADD opbp-frontend/build.gradle opbp-frontend/build.gradle
RUN gradle resolveDependencies

ADD . .
RUN gradle build buildDocker --stacktrace