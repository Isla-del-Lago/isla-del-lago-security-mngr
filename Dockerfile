FROM amazoncorretto:11

EXPOSE 9004

WORKDIR /app

COPY ./build/libs/securitymngr-1.0.0.jar .

CMD ["java", "-jar", "securitymngr-1.0.0.jar"]