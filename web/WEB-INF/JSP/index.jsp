<%@ page import="models.Etudiant" %>
<%@ page import="java.util.Collection" %>
<%@ page import="models.EtudiantDAO" %>
<%@ page import="models.Groupe" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="groups" type="java.util.List<models.Groupe>" scope="request"/>

<a href="${pageContext.request.contextPath}/do/groupEdit">Nouveau Groupe</a>

<ul>
    <% for (Groupe group: groups) {%>
    <li>
        <p><%= group.getNom()%>
            <a style="text-decoration: none;" href="${pageContext.request.contextPath}/do/groupEdit?id=<%=group.getId()%>">
                <i style="color: orange;" class="material-icons md-36">create</i>
            </a>

            <a style="text-decoration: none;" href="${pageContext.request.contextPath}/do/groupDelete?id=<%=group.getId()%>">
                <i style="color: red;" class="material-icons md-36">delete_forever</i>
            </a>
        </p>
    </li>
    <%} %>
</ul>

