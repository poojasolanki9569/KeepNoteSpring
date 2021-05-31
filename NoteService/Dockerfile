FROM openjdk:11-jre-slim
WORKDIR /usr/src
ENV MONGO_URI mongodb://localhost:27017/keepNoteStep5
ADD ./target/NoteService-0.0.1-SNAPSHOT.jar /usr/src/NoteService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar", "NoteService-0.0.1-SNAPSHOT.jar"]