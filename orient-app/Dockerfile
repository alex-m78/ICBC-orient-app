# FROM java:8  
# VOLUME /tmp   
# WORKDIR /orient-app

# RUN wget http://apache-mirror.rbc.ru/pub/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz \
#     && tar xzvf apache-maven-3.3.9-bin.tar.gz \
#     && cp -R apache-maven-3.3.9 /usr/local/bin \
#     && export PATH=apache-maven-3.3.9/bin:$PATH \
#     && export PATH=/usr/local/bin/apache-maven-3.3.9/bin:$PATH \
#     && ln -s /usr/local/bin/apache-maven-3.3.9/bin/mvn /usr/local/bin/mvn \
#     && echo $PATH

# RUN maven clean package
# ADD /orient-app/orient-app.jar /app.jar
# ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]



FROM maven AS build
COPY orient-app/src /home/app/src
COPY orient-app/pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


FROM java:8
COPY --from=build /home/app/target/orient-app.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
