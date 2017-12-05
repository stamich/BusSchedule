<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 06.06.17
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="<c:url value="/resources/theme1/css/style.css" />" rel="stylesheet">

    <title>Dodaj linie</title>
</head>
<body>
    <c:url var="action" value='lineDetails' ></c:url>

    <form:form method="post" action="${action}" modelAttribute="line">
        <table>
            <tr>
                <td><form:label path="lineNumber">Numer linii :</form:label></td>
                <td><form:input path="lineNumber" /></td>
        </tr>
        <tr>
            <td><form:label path="relation">Relacja :</form:label></td>
            <td><form:input path="relation" /></td>
        </tr>
        <tr>
            <td><form:label path="direction">Kierunek :</form:label></td>
            <td><form:input path="direction" /></td>
        </tr>
        <tr>
            <td><form:label path="validFrom">Ważny od :</form:label></td>
            <td><form:input path="validFrom" /></td>
        </tr>
        <tr>
            <td><form:label path="validTo">Ważny do :</form:label></td>
            <td><form:input path="validTo" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Dodaj linie"/></td>
        </tr>
        </table>
    </form:form>
</body>
</html>
