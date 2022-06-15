FROM amazoncorretto:11

EXPOSE 9004

WORKDIR /app

COPY ./build/lib/securitymngr-with-dependencies-1.0.0.jar .

CMD ["java", "-jar", "securitymngr-with-dependencies-1.0.0.jar"]