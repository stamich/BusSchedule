<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 06.06.17
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<div id="content">
    <span class="smalltitle">Tworzenie rekordu</span>
    <div style="height: 5px;"></div>
    <c:url var="action" value='stopDetails' ></c:url>

    <form:form method="post" action="${action}" modelAttribute="stop">
        <table>
            <tr>
                <td><form:label path="stopId">Ulica :</form:label></td>
                <td><form:input path="stopId" /></td>
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
</div>
</html>
