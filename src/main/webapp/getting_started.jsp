<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Getting Started" scope="request"/>

<c:set var="main" scope="request">
    <h1>Getting started</h1>

    <h2>Step 1: Install tools</h2>
    
    <h3>Git</h3>
    
    <p><a href="http://git-scm.com/">Git</a> is a version control system. 
        Download it from <a href="http://git-scm.com/downloads">http://git-scm.com/downloads</a>,
        or run <span class="command">sudo apt-get install git</span> or similar on Linux.
    </p>

    <h3>Java 7 SDK</h3>
    
    <p>The software we are going to test is written in the latest stable version of <a href="http://www.java.com/en/">Java</a>.
       Download Java SE Development Kit 7 for your platform on <a href="http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html">http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html</a>
    </p>

    <h3>Apache JMeter</h3>

    <p>Apache <a href="http://jmeter.apache.org/">JMeter</a> is a tool for writing and running performance tests.
        It runs on Java, and you can donwnload the latest version at <a href="http://jmeter.apache.org/download_jmeter.cgi">http://jmeter.apache.org/download_jmeter.cgi</a>.
        We use version 2.9 or newer.
    </p>
    
    <h3>Apache Maven</h3>
    
    <p>Apache <a href="http://maven.apache.org/">Maven</a> lets us build the source code and start the database and software under testing.
        Maven runs on Java, and you can download it from <a href="http://maven.apache.org/download.cgi">http://maven.apache.org/download.cgi</a>.
    </p>
    
    <h2>Step 2: Download the source</h2>
    
    <p>The software we are going to test is open source and live in a Git repository on <a href="https://github.com/kantega/techtest">https://github.com/kantega/techtest</a></p>
    
    <p>Get read only access to the source code by cloning the Git repository:</p>
    
    <p class="command">git clone git://github.com/kantega/techtest.git</p>
    <p class="command">cd techtest</p>
    
    <h2>Step 3: Build</h2>
    
    <p>We use Apache Maven to builde the source code. It will download all dependencies that we need.</p>
    
    <p class="command">mvn clean install</p>
    
    <p>If you run <span class="command">mvn clean</span> you wipe out the database.</p>
    
    <h2>Step 4: Run</h2>
    
    <h3>Database</h3>
    
    <p>To start the database, run:</p>

    <p class="command">mvn exec:java</p>
    
    <p>You want to run the database in a separate shell/terminal/command line
       window from the blog software.</p>
    
    <h3>Blog</h3>
    
    <p>If you have started a new shell/terminal/command line window after you 
       started the database, remember to put Java 7 and Apache Maven in your PATH.</p>
    
    <p>The blog can be started with:</p>

    <p class="command">mvn jetty:run-forked</p>
    
    <h2>Use the blog</h2>
    
    <p>Watch the blog at <a href="http://localhost:8080/">http://localhost:8080/</a></p>
    
    <a href="/">Back...</a>
        
</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>
