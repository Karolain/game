<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="common" tagdir="/WEB-INF/tags/common" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Purr</title>
        <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script>
            jQuery.ajaxSetup({async: false}); 
            $(document).ready(function() {
                $("area").click(function() { 
                    $("#main").load("getPossibleEvents?place=" + this.id);
                });
            });
            function processEventSelection(eventId) {
                $("#main").load("processEvent?eventId=" + eventId);
                $("#characterAttributesContainer").load("characterAttributes");
            }

        </script>
    </head>
    <body>
        <div id="wrapper">
            <nav>
                <a href="<c:url value="/newgame/" />" class="menu">New Game</a>
                <%--            <a href="#" class="menu">Load Game</a>
                            <a href="#" class="menu">Save Game</a>--%>
            </nav>
            <header>
                <div class="player-info" style="visibility: <c:out value="${empty currentCharacter ? 'hidden' : 'show'}" />;">
                    <img src="<c:url value="/resources/images/fiona-round.png" />" style="float:left;padding-right: 10px;" />
                    <details open>
                        <summary></summary>
                        <div id="characterAttributesContainer">
                            <common:characterAttributes currentCharacter="${currentCharacter}" />
                        </div>
                    </details>
                </div>
            </header>
            <div id="map">
                <div class="markings" style="visibility: <c:out value="${empty currentCharacter ? 'hidden' : 'show'}" />;">
                    <img src="<c:url value="/resources/images/markings.png" />" usemap="#townmap" />
                    <map name="townmap" id="mapping">
                        <area shape="rect" coords="169,416,382,465" href="#" id="Forest" alt="Go to Forest" />
                        <area shape="rect" coords="534,328,743,370" href="#" id="Tavern" alt="Go to Tavern" />
                        <area shape="rect" coords="559,229,766,273" href="#" id="Garden" alt="Go to Garden" />
                        <area shape="rect" coords="767,161,979,206" href="#" id="Back_alley" alt="Go to Back Alley" />
                        <area shape="rect" coords="1025,241,1238,287" href="#" id="Shooting_range" alt="Go to Shooting Range" />
                        <area shape="rect" coords="258,227,471,276" href="#" id="Wizards_tower" alt="Go to Wizard's Tower" />
                        <area shape="rect" coords="354,40,563,91" href="#" id="Hospital" alt="Go to Hospital" />
                        <area shape="rect" coords="555,93,768,142" href="#" id="Town_hall" alt="Go to Town Hall" />
                    </map>
                </div>
            </div>
            <main id="main">
            </main>
            <footer>
            </footer>
        </div>
    </body>
</html>
