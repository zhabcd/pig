FROM moxm/java:1.8-full

MAINTAINER wangiegie@gmail.com

ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom"

RUN ln -sf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

RUN mkdir -p /pig-gateway

WORKDIR /pig-gateway

EXPOSE 9999

ADD ./target/pig-gateway.jar ./

CMD sleep 60;java $JAVA_OPTS -jar pig-gateway.jar
