FROM gradle:jdk8

USER root

# Instalação do nodejs
RUN sh -c 'curl -sL https://deb.nodesource.com/setup_7.x | bash -' \
	&& apt-get install -y nodejs \
	&& alias node='nodejs'

# Instalação do yarn
RUN sh -c 'curl -sS https://dl.yarnpkg.com/debian/pubkey.gpg | apt-key add -' \
	&& echo "deb https://dl.yarnpkg.com/debian/ stable main" | tee /etc/apt/sources.list.d/yarn.list \
	&& apt-get update \ 
	&& apt-get install -y yarn

# Instalação do docker
RUN apt-get update \
	&& apt-get install -y apt-transport-https ca-certificates curl software-properties-common \
	&& sh -c 'curl -fsSL https://download.docker.com/linux/ubuntu/gpg | apt-key add -' \
	&& apt-key fingerprint 0EBFCD88 \
	&& add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu trusty stable" \
	&& apt-get update \
	&& apt-get install -y docker-ce \
	&& nohup docker daemon -H tcp://0.0.0.0:2375 -H unix:///var/run/docker.sock & \

# Executa a build
VOLUME /build
ADD . .
RUN gradle build buildDocker --stacktrace