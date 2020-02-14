<%@ page import="models.Etudiant" %>
<%@ page import="models.GestionFactory" %>
<%@ page import="models.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="etudiant" class="models.Etudiant" scope="request"/>

<html>
<head>
    <title>Détail de <%=etudiant.getPrenom()%> <%=etudiant.getNom()%></title>
</head>
<body>

    <div class="container mt-4">
        <h2>Actions :</h2>
        <div class="mt-1 mb-4">
            <a  class="btn btn-warning" href="${pageContext.request.contextPath}/do/studentEdit?id=<%=etudiant.getId()%>">
                Editer
            </a>
            <a  class="btn btn-success" href="${pageContext.request.contextPath}/do/addMark?id=<%=etudiant.getId()%>">
                Ajouter une note
            </a>
        </div>

        <h2 style="margin-bottom: 24px;">Détail de <%= etudiant.getPrenom() + " " + etudiant.getNom() %></h2>
        <p><strong>ID :</strong> <jsp:getProperty name="etudiant" property="id" /></p>
        <p><strong>Prénom :  </strong><jsp:getProperty name="etudiant" property="prenom" /></p>
        <p><strong>Nom : </strong><jsp:getProperty name="etudiant" property="nom" /></p>
        <p><strong>Nombre d'absence :</strong> <%= etudiant.getNbAbsences() %></p>
        <p><strong>Moyenne :</strong> <%= etudiant.getMoyenne() == -1 ? "Pas de note" : etudiant.getMoyenne() %></p>
        <%
            if (etudiant.getNotes().size() > 0) {
        %>
            <h3>List des notes :</h3>
            <ul>
                <%
                    for( Note note: etudiant.getNotes()) {
                %>
                    <li>
                        <%= note.getAmount() %>
                        <a style="text-decoration: none;" href="${pageContext.request.contextPath}/do/markDelete?id=<%=note.getId()%>">
                            <i  style="color: red;" class="action-item material-icons md-36">delete_forever</i>
                        </a>
                    </li>
                <%
                    }
                %>
            </ul>
        <%
            }
        %>
    </div>
</body>
</html>
