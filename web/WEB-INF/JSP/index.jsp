<%@ page import="models.Etudiant" %>
<%@ page import="java.util.Collection" %>
<%@ page import="models.EtudiantDAO" %>
<%@ page import="models.Groupe" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="groups" type="java.util.List<models.Groupe>" scope="request"/>

<style>
    html, body {
        margin: 0;
    }

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

<a href="${pageContext.request.contextPath}/do/groupEdit" class="btn btn-success">Nouveau Groupe</a>

<ul style="margin-top: 24px;">
    <% for (Groupe group: groups) {
        String nomGroupe = group.getNom();
    %>
    <li>
        <p class="group-item" onclick="function onNameClicked() {
            window.location = `${pageContext.request.contextPath}/do/groupDetails?id=<%=group.getId()%>`;
        }
        onNameClicked()"><%= nomGroupe%>
            - <%=group.getEtudiants().size()%> étudiant(s) - <%=group.getModules().size()%> module(s)
        </p>
        <a  style="text-decoration: none;" href="${pageContext.request.contextPath}/do/groupEdit?id=<%=group.getId()%>">
            <i style="color: orange;" class="action-item material-icons md-36">create</i>
        </a>

        <a style="text-decoration: none;" href="${pageContext.request.contextPath}/do/groupDelete?id=<%=group.getId()%>">
            <i  style="color: red;" class="action-item material-icons md-36">delete_forever</i>
        </a>
    </li>
    <%} %>
</ul>

