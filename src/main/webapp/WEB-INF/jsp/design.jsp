<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <title>Kantega testing workshop - ${title}</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/blog.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/internett.css" media="screen"/>
        <!--[if (lt IE 9)&(!IEMobile)]>
            <link media="screen" rel="stylesheet" href="/assets/css/bootstrap.css"/>
            <link media="screen" rel="stylesheet" href="/assets/css/editor.css"/>"/>
            <link media="screen" rel="stylesheet" href="/assets/css/global.css"/>"/>
            <link media="screen" rel="stylesheet" href="/assets/css/desktop.css"/>"/>
            <link media="screen" rel="stylesheet" href="/assets/css/ie8.css"/>"/>
        <![endif]-->

    <style type="text/css">
        body {
            <c:if test="${not empty backgroundColor}">
                background-color: ${backgroundColor};
            </c:if>
        }
    </style>
    ${head}
</head>

<body>

<body>
<div id="page-container">

<div class="accessibility-skip-links" style="display: none">
    <ol>
        <li>
            <a href="#mainMenu">Hopp til hovedmeny</a>
        </li>
        <li>
            <a href="#sideinnhold-start">Hopp til sideinnhold</a>
        </li>
        <li>
            <a href="#global-search-input">Hopp til søk</a>
        </li>
    </ol>
</div>



    <script type="text/javascript">
        var _gaq = _gaq || [];
        _gaq.push(['_setAccount', 'UA-17108442-1']);
        _gaq.push(['_trackPageview']);
        _gaq.push(['_setDomainName', 'kantega.no']);

        (function() {
            var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
            ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
            var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
        })();
    </script>









<div id="topsection" class="always-fullwidth">
<!--      -->
    <div id="header">
        <div class="container">
            <div class="row">
                <div class="span2">
                    <a href="/internett/" class="logoLink noLinkEffect" title="Til forsiden">
                        <img src="/assets/bitmaps/kantega_logo.png">
                    </a>
                    <a href="#mobile-navigation" class="mobile-menu-anchor"></a>
                </div>

                <section class="hidden-phone">







<nav id="desktop-navigation" class="always-fullwidth">


    <div class="span8" id="mainMenu">
        <ul>
	<li>

            <a title="Workshop" href="/">Workshop</a>

        </li>
	<li>

            <a title="Blogs" href="/blogs">Blogs</a>

        </li>
            <li>

                <a title="Statys" href="/status">Status</a>

            </li>

	<li>

            <a title="Om Kantega" href="http://kantega.no/jobb/">About Kantega</a>

	</ul>

    </div>
</nav>
                </section>

            </div>
        </div>

    </div>



</div>



<div id="mainsection">

    <div class="container">
        <div class="articleLayout">

            <div class="content">
            ${main}
            </div>

    </div>

</div>






<div class="footerspacer">&nbsp;</div>
</div>

<section class="visible-phone">








<div id="footer" class="always-fullwidth">
    <div class="container">
        <div class="row">
            <div class="span3 hidden-phone">
                <img class="spaa" src="/bitmaps/internett/spa.png" alt="Kantega - Nesten litt magisk" title="Kantega - Nesten litt magisk">
            </div>
            <div class="span6 om-kantega">
                <h3>
                    Hvem er vi?
                </h3>
                <p>
                    Kantega er et norsk IT-konsulentselskap med spisskompetanse innen rådgivning, design, systemutvikling, test, integrasjon og forvaltning. Vi leverer nyskapende selvbetjenings- og saksbehandlingsløsninger. Unike løsninger med høy kvalitet og lave livsløpskostnader.
                </p>
            </div>
            <div class="span3">
                <div class="social">
                    <h3 class="">Følg oss</h3>

                </div>
            </div>
        </div>
    </div>
</div>






<script type="text/javascript">
    WebFontConfig = {
        google: { families: [ 'PT+Sans:400,700,400italic,700italic:latin' ] }
    };
    (function() {
        var wf = document.createElement('script');
        wf.src = ('https:' == document.location.protocol ? 'https' : 'http') +
                '://ajax.googleapis.com/ajax/libs/webfont/1/webfont.js';
        wf.type = 'text/javascript';
        wf.async = 'true';
        var s = document.getElementsByTagName('script')[0];
        s.parentNode.insertBefore(wf, s);
    })();
</script>

<div class="status">
<a href="<%=request.getContextPath()%>/status">Status</a>
<a href="<%=request.getContextPath()%>/admin">Admin</a>
<c:if test="${sessionScope.admin != null}">
    <a href="<%=request.getContextPath()%>/logout">Log out</a>
</c:if>
</div>

</body>
</html>