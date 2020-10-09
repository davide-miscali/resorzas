@echo off

IF [%1] == [] GOTO Error

@echo on
java -jar ${launch.name}.jar --spring.config.location=%1
@echo off

GOTO End

:Error
echo Hit an error; Could be parameters are missing?
echo Expected use is to specify the property file eg: "gpl-application.properties"
:End