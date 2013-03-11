<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="title" value="Create a blog" scope="request"/>

<c:set var="main" scope="request">
    <h1>Create a test</h1>

    <p class="ingress">We are going to create a simple JMeter test using the following elements:</p>
    
    <ul>
        <li>Structure
            <ul>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#Thread_Group" target="_blank">Thread Group</a></li>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#Simple_Controller" target="_blank">Simple Controller</a></li>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#Throughput_Controller" target="_blank">Throughput Controller</a></li>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#Random_Variable" target="_blank">Random Variable</a></li>
            </ul>
        </li>
        <li>Samplers
            <ul>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#HTTP_Request" target="_blank">HTTP Request Sampler</a></li>
                <li>Assertions
                    <ul>
                        <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#Response_Assertion" target="_blank">Response Assertion</a></li>
                    </ul>
                </li>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#HTTP_Request" target="_blank">POSTing data</a></li>
            </ul>
        </li>
        <li>Navigate
            <ul>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#Regular_Expression_Extractor" target="_blank">Regular Expression Extractor</a></li>
            </ul>
        </li>
        <li>HTTP Common
            <ul>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#HTTP_Request_Defaults" target="_blank">HTTP Request Defaults</a></li>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#HTTP_Cookie_Manager" target="_blank">HTTP Cookie Manager</a></li>
            </ul>
        </li>
        <li>Debug
            <ul>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#View_Results_Tree" target="_blank">View Results Tree</a></li>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#Debug_Sampler" target="_blank">Debug Sampler</a></li>
            </ul>
        </li>
        <li>Reports
            <ul>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#Aggregate_Report" target="_blank">Aggregate Report</a></li>
                <li><a href="http://jmeter.apache.org/usermanual/component_reference.html#Graph_Results" target="_blank">Graph Results</a></li>
            </ul>
        </li>
    </ul>

    <a href="/">Back...</a>
</c:set>

<jsp:include page="WEB-INF/jsp/design.jsp"/>