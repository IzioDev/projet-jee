<%@ page import="models.Etudiant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="group" class="models.Groupe" scope="request"/>

<style>
    .action-item {
        font-size: 36px;
    }
</style>

<h2>Liste des etudiant du groupe <%=group.getNom()%></h2>
<ul>
<%
    for (Etudiant etudiant: group.getEtudiants()) {
%>
  <li style="font-size: 26px;">
      <%= etudiant.getPrenom()%> <%= etudiant.getNom() %> - <%= etudiant.getNbAbsences() %> abscence(s)
      <a  style="text-decoration: none;" href="${pageContext.request.contextPath}/do/studentEdit?id=<%=etudiant.getId()%>">
          <i style="color: orange;" class="action-item material-icons md-36">create</i>
      </a>

      <a style="text-decoration: none;" href="${pageContext.request.contextPath}/do/studentDelete?id=<%=etudiant.getId()%>">
          <i  style="color: red;" class="action-item material-icons md-36">delete_forever</i>
      </a>
  </li>
<%
    }
%>
</ul>

<%
    if (group.getEtudiants().size() == 0) {
%>
    <p>Pas d' etudiant pour le moment, veuillez en creer un en cliquant sur Ajouter un etudiant dans le menu du haut.</p>
<%
    }
%>