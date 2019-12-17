<%@ page import="models.Etudiant" %>
<%@ page import="java.util.Collection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Moyenne des étudiants</title>
</head>
<body>
    <jsp:include page='<%= application.getInitParameter("navbar")%>' />
    <div style="margin-left: 10%; margin-right: 10%;">
        <%
            for(Etudiant etudiant: (Collection<Etudiant>) request.getAttribute("etudiants")) {
        %>
        <p><%= etudiant.getPrenom() + " " + etudiant.getNom() %> : <span style="font-weight: bold"><%=etudiant.getMean()%> de moyenne</span>
            <a href="${pageContext.request.contextPath}/do/studentDetails?studentId=<%=etudiant.getId()%>">Détails</a>
        </p>

        <%
            }
        %>
    </div>
</body>
</html>
