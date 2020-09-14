@echo off

REM java -jar kafka-to-file-connector-1.0.0.jar --spring.config.location=./gpl-application.properties

IF [%1] == [] GOTO Error


REM java -jar kafka-to-file-connector-1.0.0.jar --spring.config.location=%1 --camel.component.properties.location=%1

REM java -jar kafka-to-file-connector-1.0.0.jar --spring.config.location=%1 -Dgpl.external.config.location=%1 --camel.component.properties.location=%1

@echo on
java -jar kafka-to-file-connector-1.0.0.jar --spring.config.location=%1 -Dgpl.external.config.location=%1 -Dcamel.component.properties.location=%1
@echo off

GOTO End

:Error
echo Hit an error; Could be parameters are missing?
echo Expected use is to specify the property file eg: "gpl-application.properties"
:End