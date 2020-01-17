<%@ page import="models.Module" %>
<jsp:useBean id="modules" type="java.util.List<models.Module>" scope="request"/>

<a href="${pageContext.request.contextPath}/do/moduleEdit">Nouveau Module</a>
<ul>
<% for (Module module: modules) {%>
    <li>
        <p><%= module.getNom()%>
            <a style="text-decoration: none;" href="${pageContext.request.contextPath}/do/moduleDelete?id=<%=module.getId()%>">
                <i style="color: orange;" class="material-icons md-36">create</i>
            </a>

            <a style="text-decoration: none;" href="${pageContext.request.contextPath}/do/moduleDelete?id=<%=module.getId()%>">
                <i style="color: red;" class="material-icons md-36">delete_forever</i>
            </a>
        </p>
    </li>

<%} %>
</ul>