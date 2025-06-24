# Use the official OpenJDK 17 image
# FROM openjdk:17

# # Create a temporary volume folder
# VOLUME /tmp

# # Copy the compiled Spring Boot application JAR
# COPY springboot-lawfirm/target/lawfirm-0.0.1-SNAPSHOT.jar app.jar

# # Command to run the JAR file
# ENTRYPOINT ["java","-jar","/lawfirm.jar"]

FROM openjdk:17
WORKDIR /app
COPY springboot-lawfirm/target/lawfirm-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]