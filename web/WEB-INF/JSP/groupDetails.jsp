<%@ page import="models.Etudiant" %>
<%@ page import="models.Note" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="group" class="models.Groupe" scope="request"/>

<style>
    .action-item {
        font-size: 36px;
    }
    .group-item {
        font-size: 26px;
        color: #4f6bff;
        display: inline;
    }
    .group-item:hover {
        color: #ff7246;
        cursor: pointer;
    }
</style>

<h2>Liste des etudiant du groupe <%=group.getNom()%></h2>
<ul>
<%
    for (Etudiant etudiant: group.getEtudiants()) {
      float moyenne = -1;
      float sum = 0;
      for (Note note: etudiant.getNotes()) {
        sum += note.getAmount();
      }

      if (etudiant.getNotes().size() > 0) {
          moyenne = sum / etudiant.getNotes().size();
          moyenne = (float) Math.ceil(moyenne * 100) / 100;
      }
%>
  <li style="font-size: 26px;">
      <p class="group-item" onclick="function onNameClicked() {
              window.location = `${pageContext.request.contextPath}/do/studentDetail?id=<%=etudiant.getId()%>`;
      }onNameClicked()">
              <%= etudiant.getPrenom()%> <%= etudiant.getNom() %> - <%= etudiant.getNbAbsences() %> abscence(s) - <%= moyenne != -1 ? moyenne + " de moyenne" : "Pas de notes"%>
      </p>
      <a  style="text-decoration: none;" href="${pageContext.request.contextPath}/do/studentEdit?id=<%=etudiant.getId()%>">
          <i style="color: orange;" class="action-item material-icons md-36">create</i>
      </a>

      <a style="text-decoration: none;" href="${pageContext.request.contextPath}/do/studentDelete?id=<%=etudiant.getId()%>">
          <i  style="color: red;" class="action-item material-icons md-36">delete_forever</i>
      </a>

      <a style="text-decoration: none;" href="${pageContext.request.contextPath}/do/addMark?id=<%=etudiant.getId()%>">
          <i  style="color: green;" class="action-item material-icons md-36">note_add</i>
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