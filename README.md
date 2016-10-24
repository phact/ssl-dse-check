# ssl-dse-check

##Build and run

    mvn package shade:shade
    java -jar target/ssl-dse-check-1.0-SNAPSHOT.jar  localhost /tmp/truststore.client 

##Or download and run

    wget https://github.com/phact/ssl-dse-check/releases/download/v0/ssl-dse-check-1.0-SNAPSHOT.jar
    java -jar ssl-dse-check-1.0-SNAPSHOT.jar  localhost /tmp/truststore.client 
