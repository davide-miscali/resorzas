mvn install:install-file -Dfile=oracleDependencies/wlfullclient.jar -DgroupId=com.oracle -DartifactId=wlfullclient -Dversion=12.1.0.1 -Dpackaging=jar -DgeneratePom=true

mvn install:install-file -Dfile=oracleDependencies/wljmsclient.jar -DgroupId=com.oracle -DartifactId=wljmsclient -Dversion=12.1.0.1 -Dpackaging=jar -DgeneratePom=true


wlthint3client.jar


mvn install:install-file -Dfile=oracleDependencies/wlthint3client.jar -DgroupId=com.oracle -DartifactId=wlthint3client -Dversion=12.1.0.1 -Dpackaging=jar -DgeneratePom=true