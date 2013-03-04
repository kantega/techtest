techtest
========

App for performance / stability testing workshop

Getting started
---------------

Starting the database:

    mvn exec:java

Building the source code:

    mvn clean install

Running the server:

    JAVA_HOME=/opt/jdk1.7.0_04/ mvn jetty:run-forked

To see a beautiful blog, you can now navigate to:

    http://localhost:8080/
