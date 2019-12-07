<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="models.GestionFactory" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Etudiant" %>
<%@ page import="java.util.Collection" %>

<%!
    Collection<Etudiant> etudiants = GestionFactory.getEtudiants();
%>

<html>
<head>
    <title>$Title$</title>
</head>
<body>
  <% for (Etudiant etudiant : etudiants) { %>
    <div>
      <a href="${pageContext.request.contextPath}/servlettraitementdetails?etudiantId=<%=etudiant.getId()%>"><%= etudiant.getNom() + " " + etudiant.getPrenom() %>
      </a>
    </div>
  <%}%>
</body>
</html>
