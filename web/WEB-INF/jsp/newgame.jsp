<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" />
        <title>Purr</title>
    </head>
    <body>
        <div class="selection">
            <h1>New game</h1>
            <p>Select your character.</p>
            <div class="character">
                <a href="<c:url value="/startgame/?character=fiona" />"><img class="character" src="<c:url value="/resources/images/fiona.png" />" /></a>
            </div>
        </div>
        <nav></nav>
        <header>
            <div class="player-info"></div>
        </header>
        <div id="map-opacity"></div>
        <div id="wrapper">
            <footer>
            </footer>
        </div>
    </body>
</html>
