FROM gradle:jdk-21-and-22


WORKDIR /app

COPY . .

RUN ./gradlew clean
RUN ./gradlew build  --scan --info




ENTRYPOINT ["java", "-jar", "/app/build/libs/desafio-tecnico-0.0.1-SNAPSHOT.jar"]
