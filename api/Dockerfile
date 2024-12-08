FROM gradle:jdk-21-and-22


WORKDIR /app

COPY . .

RUN ./gradlew clean

CMD ./gradlew bootRun --scan --info --continuous
