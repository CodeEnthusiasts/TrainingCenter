FROM openjdk:11
ADD build/libs/TrainingCenterApp-0.0.1-SNAPSHOT.jar .
EXPOSE 8002
CMD java -jar TrainingCenterApp-0.0.1-SNAPSHOT.jar --envname=postgres

