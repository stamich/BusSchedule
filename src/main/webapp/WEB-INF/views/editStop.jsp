<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 06.06.17
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <link href="<c:url value="/resources/theme1/css/style.css" />" rel="stylesheet">

    <title>Edytuj przystanki</title>
</head>
<body>
    <spring:url value="stop" var="stop" />

    <a href="${stop}">Register</a>

    <c:url var="action" value="/update"></c:url>

    <form:form method="post" action="${action}" modelAttribute="stop">
        <table>
            <tr>
                <td><form:label path="stopId">Ulica :</form:label></td>
                <td><form:input path="stopId" /></td>
            </tr>
            <tr>
                <td><form:label path="street">Ulica :</form:label></td>
                <td><form:input path="street" /></td>
            </tr>
            <tr>
                <td><form:label path="stopName">Nazwa przystanku :</form:label></td>
                <td><form:input path="stopName" /></td>
            </tr>
            <tr>
                <td><form:label path="lineNumber">Numer linii :</form:label></td>
                <td><form:input path="lineNumber" /></td>
            </tr>
            <tr>
                <td><form:label path="direction">Kierunek :</form:label></td>
                <td><form:input path="direction" /></td>
            </tr>
            <tr>
                <td><form:label path="departTime">Godz. odjazdu :</form:label></td>
                <td><form:input path="departTime" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Dodaj przyst."/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
