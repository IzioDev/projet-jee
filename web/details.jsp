<%@ page import="models.Etudiant" %>
<%@ page import="models.GestionFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Etudiant etudiant = GestionFactory.getEtudiantById(Integer.parseInt(request.getParameter("etudiantId")));
    %>

    <p>Prénom : <%= etudiant.getPrenom()%></p>
    <p>Nom : <%= etudiant.getNom()%></p>
    <p>ID : <%= etudiant.getId()%></p>
</body>
</html>
