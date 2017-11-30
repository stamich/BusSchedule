<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 30.05.17
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="content">
    <span class="smalltitle">Linie MZK</span>
    <div style="height: 5px;"></div>
    <table id="table">
        <thead>
        <tr>
            <td>Numer przystanku</td><td>Ulica</td><td>Nazwa przystanku</td><td>Numer linii</td><td>Kierunek</td><td>Godz. odjazdu</td><td>Usuwanie</td>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <td>(Edycja)</td><td>Ulica</td><td>Nazwa przystanku</td><td>Numer linii</td><td>Kierunek</td><td>Godz. odjazdu</td><td>Usuwanie</td>
        </tr>
        </tfoot>
        <c:forEach items="${stop}" var="agreement">
            <tr>
                <td>${stop.stopId}</td>
                <td><a href="<c:url value='/edit-${stop.stopId}-agreement' />">${stop.stopId}</a></td>
                <td>${stop.street}</td>
                <td>${stop.stopName}</td>
                <td>${stop.lineNumber}</td>
                <td>${stop.direction}</td>
                <td>${stop.departTime}</td>
                <td><a href="<c:url value='/delete-${stop.stopId}-agreement' />">Usuń</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
