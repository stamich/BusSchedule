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
    <link href="<c:url value="/resources/theme1/css/style.css" />" rel="stylesheet">
    <title>Rozkład jazdy</title>
</head>
<body>
<div id="content">
    <span class="smalltitle">Linie MZK</span>
    <div style="height: 5px;"></div>
    <c:if test="${!empty lineList}">
    <table id="table">
        <thead>
        <tr>
            <td>Id</td><td>Numer linii</td><td>Relacja</td><td>Kierunek</td><td>Ważny od</td><td>Ważny do</td><td>Usuwanie</td>
        </tr>
        </thead>
        <tfoot>
        <tr>
            <td>Id</td><td>(Edycja)</td><td>Relacja</td><td>Kierunek</td><td>Ważny od</td><td>Ważny do</td><td>Usuwanie</td>
        </tr>
        </tfoot>
        <c:forEach items="${lineList}" var="line">
            <tr>
                <td>${line.lineId}</td>
                <td><a href="<c:url value='/edit-${line.lineNumber}-agreement' />">${line.lineNumber}</a></td>
                <td>${line.relation}</td>
                <td>${line.direction}</td>
                <td>${line.validFrom}</td>
                <td>${line.validTo}</td>
                <td><a href="<c:url value='/delete-${line.lineNumber}-agreement' />">Usuń</a></td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
</div>
</body>
</html>
