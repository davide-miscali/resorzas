@echo off

IF [%1] == [] GOTO Error

@echo on
java -jar kafka-to-file-connector-1.0.0.jar --spring.config.location=%1
@echo off

GOTO End

:Error
echo Hit an error; Could be parameters are missing?
echo Expected use is to specify the property file eg: "gpl-application.yml"
:End