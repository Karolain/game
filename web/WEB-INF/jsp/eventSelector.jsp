<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p>What do you want to do?</p>
<c:forEach items="${possibleEvents}" var="event">
    <a href="javascript:processEventSelection(${event.id});" class="eventSelection" style="color: #BF986A;text-decoration: none;font-weight: bold;">${event.name}</a>
</c:forEach>