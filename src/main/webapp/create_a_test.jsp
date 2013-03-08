<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Create a blog" scope="request"/>

<c:set var="main" scope="request">
    <h1>Create a test</h1>

    <p>We are going to create a simple JMeter test using the following elements:</p>
    
    <ul>
        <li>Structure
            <ul>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#Thread_Group">Thread Group</a></li>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#Simple_Controller">Simple Controller</a></li>
            </ul>
        </li>
        <li>Samplers
            <ul>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#HTTP_Request">HTTP Request Sampler</a></li>
                <li>Assertions
                    <ul>
                        <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#HTML_Assertion">HTML Assertion</a></li>
                        <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#Response_Assertion">Response Assertion</a></li>
                    </ul>
                </li>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#HTTP_Request">POSTing data</a></li>
            </ul>
        </li>
        <li>Navigate
            <ul>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#Regular_Expression_Extractor">Regular Expression Extractor</a></li>
            </ul>
        </li>
        <li>HTTP Common
            <ul>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#HTTP_Request_Defaults">HTTP Request Defaults</a></li>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#HTTP_Cookie_Manager">HTTP Cookie Manager</a></li>
            </ul>
        </li>
        <li>Debug
            <ul>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#View_Results_Tree">View Results Tree</a></li>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#Debug_Sampler">Debug Sampler</a></li>
            </ul>
        </li>
        <li>Reports
            <ul>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#Aggregate_Report">Aggregate Report</a></li>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#Graph_Results">Graph Results</a></li>
            </ul>
        </li>
    </ul>

    <a href="/">Back...</a>
</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>