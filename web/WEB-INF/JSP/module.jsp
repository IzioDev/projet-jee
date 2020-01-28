<%@ page import="models.Module" %>
<jsp:useBean id="modules" type="java.util.List<models.Module>" scope="request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>
    .action-item {
        font-size: 36px;
    }
</style>

<a href="${pageContext.request.contextPath}/do/moduleEdit" class="btn btn-success">Nouveau Module</a>
<ul style="margin-top: 24px;">
<% for (Module module: modules) {%>
    <li>
        <p style="font-size: 26px;"><%= module.getNom()%>
            <a style="text-decoration: none;" href="${pageContext.request.contextPath}/do/moduleEdit?id=<%=module.getId()%>">
                <i style="color: orange;" class="action-item material-icons md-36">create</i>
            </a>

            <a style="text-decoration: none;" href="${pageContext.request.contextPath}/do/moduleDelete?id=<%=module.getId()%>">
                <i style="color: red;" class="action-item material-icons md-36">delete_forever</i>
            </a>
        </p>
    </li>

<%} %>
</ul>