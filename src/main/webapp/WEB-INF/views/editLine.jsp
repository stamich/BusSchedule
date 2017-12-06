<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 06.06.17
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<spring:url value="lines" var="lines" />

<a href="${lines}">Register</a>

<c:url var="action" value="/update"></c:url>

<form:form method="post" action="${action}" modelAttribute="line">
    <table>
        <tr>
            <td>
                <form:hidden path="lineId" />
                <form:label path="lineNumber">Numer linii :</form:label></td>
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
</html>
