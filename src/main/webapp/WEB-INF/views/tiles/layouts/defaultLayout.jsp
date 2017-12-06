<%--
  Created by IntelliJ IDEA.
  User: michal
  Date: 06.11.17
  Time: 18:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title" /></title>

    <link href="<c:url value='/resources/theme1/css/style.css' />" rel="stylesheet"></link>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link href="<c:url value="/resources/theme1/css/style.css" />" rel="stylesheet">

    <spring:url value="http://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css" var="jquerydtcss" />
    <link href="${jquerydtcss}" rel="stylesheet" />

    <spring:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js" var="jqueryJs" />
    <script src="${jqueryJs}"></script>

    <spring:url value="http://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js" var="jquerydt" />
    <script src="${jquerydt}"></script>

    <script type="text/javascript" >
        $(document).ready(function (){
            $('#table').DataTable({
            });
        });
    </script>
</head>
<body>
<div id="container">
    <header id="header">
        <tiles:insertAttribute name="header" />
    </header>
    <section id="sidemenu">
        <tiles:insertAttribute name="menu" />
    </section>

    <section id="site-content">
        <tiles:insertAttribute name="body" />
    </section>

    <footer id="footer">
        <tiles:insertAttribute name="footer" />
    </footer>
</div>
</body>
</html>
