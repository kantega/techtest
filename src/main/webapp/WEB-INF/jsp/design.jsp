<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
    <title>Kantega testing workshop - ${title}</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/blog.css">
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/assets/css/internett.css" media="screen"/>
        <!--[if (lt IE 9)&(!IEMobile)]>
            <link media="screen" rel="stylesheet" href="/assets/css/bootstrap.css"/>
            <link media="screen" rel="stylesheet" href="/assets/css/editor.css"/>"/>
            <link media="screen" rel="stylesheet" href="/assets/css/global.css"/>"/>
            <link media="screen" rel="stylesheet" href="/assets/css/desktop.css"/>"/>
            <link media="screen" rel="stylesheet" href="/assets/css/ie8.css"/>"/>
        <![endif]-->

    <style type="text/css">
        .articleLayout {
            <c:if test="${not empty backgroundColor}">
                background-color: ${backgroundColor};
            </c:if>
        }
    </style>
    ${head}
</head>

<body>
<div id="page-container">

<div id="topsection" class="always-fullwidth">
<!--      -->
    <div id="header">
        <div class="container">
            <div class="row">
                <div class="span2">
                    <a href="/" class="logoLink noLinkEffect" title="Til forsiden">
                        <img src="/assets/bitmaps/kantega_logo.png" alt="Kantega Logo">
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

                <a title="Status" href="/status">Status</a>

            </li>
            <li>

                <a title="Admin" href="/admin">Admin</a>

            </li>

	<li>

            <a title="Om Kantega" target="_blank" href="http://kantega.no/jobb/">About Kantega</a>

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

</body>
</html>