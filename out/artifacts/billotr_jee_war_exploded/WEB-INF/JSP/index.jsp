<%@ page import="models.Etudiant" %>
<%@ page import="java.util.Collection" %>
<%@ page import="models.GestionFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%!
    Collection<Etudiant> etudiants = GestionFactory.getEtudiants();
%>

<html>
<title>Gestion des étudiants</title>
<body>
    <div style="margin-left: 10%; margin-right: 10%;">
        <p>Cliquez sur un étudiant pour voir le détail de l'étudiant.</p>

        <div style="margin-top: 12px">
            <% for (Etudiant etudiant : etudiants) { %>
            <div>
                <a href="${pageContext.request.contextPath}/do/studentDetails?studentId=<%=etudiant.getId()%>"><%= etudiant.getNom() + " " + etudiant.getPrenom() %>
                </a>
            </div>
            <%}%>
        </div>

    </div>

    <jsp:include page='<%= application.getInitParameter("footer")%>' />
</body>
</html>
