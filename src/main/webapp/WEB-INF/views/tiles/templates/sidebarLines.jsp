<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 06.11.17
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<div id="sidebar">
    <nav>
        <div class="optionL"><a href="${pageContext.request.contextPath}/">Strona główna</a></div>
        <div class="optionL"><a href="<c:url value='/createLine' />">Dodaj linię</a></div>
        <div class="optionL"><a href="${pageContext.request.contextPath}/stops">Przystanki</a></div>
        <div class="optionL"><a href="${pageContext.request.contextPath}/description">O aplikacji</a></div>
        <div style="clear:both;"></div>
    </nav>
</div>
