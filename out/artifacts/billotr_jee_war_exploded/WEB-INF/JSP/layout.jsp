<%--
  Created by IntelliJ IDEA.
  User: izio
  Date: 17/01/2020
  Time: 10:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="content" class="java.lang.String" scope="request"/>

<html>
<head>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
    <title><%= application.getInitParameter("title")%></title>
</head>
<body>

<jsp:include page="<%= application.getInitParameter(\"navbar\")%>"/>
<h1><%= application.getInitParameter("title")%></h1>

<jsp:include page="<%=content%>" />

</body>
</html>
