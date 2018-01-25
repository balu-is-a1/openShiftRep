FROM java:8
VOLUME /tmp
ADD PnrService-1.0.0.jar PnrService.jar
EXPOSE 8080
CMD ["java", "-jar", "/PnrService.jar"]







