<%@ page import="models.Module" %>
<jsp:useBean id="modules" type="java.util.List<models.Module>" scope="request"/>

<a href="${pageContext.request.contextPath}/do/moduleEdit">Nouveau Module</a>
<% for (Module module: modules) {%>
    <p><%= module.getNom()%></p>
<%} %>