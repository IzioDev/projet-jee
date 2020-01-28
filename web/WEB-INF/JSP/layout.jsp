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
    <meta charset="UTF-8"/>
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
          rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title><%= application.getInitParameter("title")%></title>
</head>
<body>

<jsp:include page="<%= application.getInitParameter(\"navbar\")%>"/>
<div class="container">
    <jsp:include page="<%=content%>" />
</div>


<jsp:include page='<%= application.getInitParameter(\"footer\")%>' />

</body>
</html>
