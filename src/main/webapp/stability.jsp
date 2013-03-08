<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Stability" scope="request"/>

<c:set var="main" scope="request">
    <h1>Stability</h1>
    
    <p class="ingress">After it has been running for a while the blog server start getting hickup.
        Suddenly it has 10 second periods where it stops responding to page views.
        After even longer time is crashes with out of memory exception.</p>
        
    <div class="email">
        <div class="mailheader">
            <p><b>From:</b> BOFH &lt;it_ops@blogprovider.com&gt;</p>
            <p><b>To:</b> Blog Software Development Team &lt;blogs@development.com&gt;</p>
            <p><b>Date:</b> 2012-03-14 12:13:37</p>
            <p><b>Importance: </b>High!</p>
            <p><b>Subject:</b> Crash with OOM in Prod!</p>
        </div>

        <div class="mailbody">
            <p>Hi,</p> 

            <p>thanks for fixing the nightly restart problem - 
               now we have a weekly restart problem instead :(</p>
            
             
            <p>This breaks the <a href="sla.jsp">SLA</a>!</p>
            
            <p>Take a look at the attached stacktrace...</p>

            <pre>Exception in thread "ContainerBackgroundProcessor[StandardEngine[Catalina]]" java.lang.OutOfMemoryError: Java heap space
        at java.util.Arrays.copyOfRange(Arrays.java:3210)
        at java.lang.String.<init>(String.java:216)
        at java.lang.StringBuffer.toString(StringBuffer.java:585)
        at org.netbeans.lib.profiler.server.ProfilerRuntimeMemory.traceVMObjectAlloc(ProfilerRuntimeMemory.java:170)
        at java.lang.Throwable.getStackTraceElement(Native Method)
        at java.lang.Throwable.getOurStackTrace(Throwable.java:590)
        at java.lang.Throwable.getStackTrace(Throwable.java:582)
        at org.apache.juli.logging.DirectJDKLog.log(DirectJDKLog.java:155)
        at org.apache.juli.logging.DirectJDKLog.error(DirectJDKLog.java:135)
        at org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor.processChildren(ContainerBase.java:1603)
        at org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor.processChildren(ContainerBase.java:1610)
        at org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor.run(ContainerBase.java:1590)
        at java.lang.Thread.run(Thread.java:619)
Exception in thread "*** JFluid Monitor thread ***" java.lang.OutOfMemoryError: Java heap space
        at java.util.Arrays.copyOf(Arrays.java:2760)
        at java.util.Arrays.copyOf(Arrays.java:2734)
        at java.util.Vector.ensureCapacityHelper(Vector.java:226)
        at java.util.Vector.add(Vector.java:728)
        at org.netbeans.lib.profiler.server.Monitors$SurvGenAndThreadsMonitor.updateSurvGenData(Monitors.java:230)
        at org.netbeans.lib.profiler.server.Monitors$SurvGenAndThreadsMonitor.run(Monitors.java:169)
Nov 30, 2009 2:22:05 PM org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor processChildren
SEVERE: Exception invoking periodic operation:
java.lang.OutOfMemoryError: Java heap space
        at java.lang.StringCoding$StringEncoder.encode(StringCoding.java:232)
        at java.lang.StringCoding.encode(StringCoding.java:272)
        at java.lang.String.getBytes(String.java:946)
        at java.io.UnixFileSystem.getLastModifiedTime(Native Method)
        at java.io.File.lastModified(File.java:826)
        at org.apache.catalina.startup.HostConfig.checkResources(HostConfig.java:1175)
        at org.apache.catalina.startup.HostConfig.check(HostConfig.java:1269)
        at org.apache.catalina.startup.HostConfig.lifecycleEvent(HostConfig.java:296)
        at org.apache.catalina.util.LifecycleSupport.fireLifecycleEvent(LifecycleSupport.java:118)
        at org.apache.catalina.core.ContainerBase.backgroundProcess(ContainerBase.java:1337)
        at org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor.processChildren(ContainerBase.java:1601)
        at org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor.processChildren(ContainerBase.java:1610)
        at org.apache.catalina.core.ContainerBase$ContainerBackgroundProcessor.run(ContainerBase.java:1590)
        at java.lang.Thread.run(Thread.java:619)
ERROR [JobRunShell]: Job updateVendorData.quoteUpdate threw an unhandled Exception:
java.lang.OutOfMemoryError: Java heap space
        at java.util.Arrays.copyOfRange(Arrays.java:3210)
        at java.lang.String.<init>(String.java:216)
        at java.lang.StringBuffer.toString(StringBuffer.java:585)
        at org.apache.commons.dbcp.PoolingConnection$PStmtKey.hashCode(PoolingConnection.java:296)
        at java.util.HashMap.get(HashMap.java:300)
        at org.apache.commons.pool.impl.GenericKeyedObjectPool.decrementActiveCount(GenericKeyedObjectPool.java:1085)
        at org.apache.commons.pool.impl.GenericKeyedObjectPool.returnObject(GenericKeyedObjectPool.java:882)
        at org.apache.commons.dbcp.PoolablePreparedStatement.close(PoolablePreparedStatement.java:80)
        at org.apache.commons.dbcp.DelegatingStatement.close(DelegatingStatement.java:168)
        at com.netcore.smsapps.stock.db.CompanyDaoImpl.updateCompanyQuote(CompanyDaoImpl.java:173)
        at com.netcore.smsapps.stock.vendor.MyirisVendor.readScripQuotes(MyirisVendor.java:159)
        at com.netcore.smsapps.stock.update.StockUpdateData.execute(StockUpdateData.java:38)
        at org.quartz.core.JobRunShell.run(JobRunShell.java:207)
        at org.quartz.simpl.SimpleThreadPool$WorkerThread.run(SimpleThreadPool.java:525).</pre>
            
            <p>Regards,<br/> 
            BOFH</p>
          </div>
    </div>
    
    <h2>Task</h2>
    
    <p>Run a stability test to check what happens when you test the software for a while.</p>
    
    <p class="tip">Use load profile and data from scalability test to find good setting for the test.</p>
    
    <p class="tip">
        Memory leaks with session? Use of Cookie manager.
        Show JVisual VM.
    </p>
    
    <a href="/">Back...</a>
        
</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>