<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .nav-item {
        color: white;
        margin-right: 24px;
        text-decoration: none;
        font-weight: 700;
        font-size: 26px;
        line-height: 64px;
    }
    .nav-item:hover {
        color: #ff7246;
    }
    .nav-container {
        width: 100%;
        text-align: center;
        margin-bottom: 24px;
        background-color: #202b41;
    }
</style>
<nav class="nav-container">
        <%-- Liste des étudiants --%>
    <a class="nav-item" href="${pageContext.request.contextPath}/do/index"> Les groupes </a>

    <a class="nav-item" href="${pageContext.request.contextPath}/do/moduleList"> Les modules </a>

    <a class="nav-item" href="${pageContext.request.contextPath}/do/studentEdit"> Ajouter un étudiant </a>
        <%-- Liste de notes --%>
<%--    <a class="nav-item" href="${pageContext.request.contextPath}/do/marksList"> Les notes </a>--%>
<%--
    <a class="nav-item" href="${pageContext.request.contextPath}/do/marksEdit"> Modifier les notes </a>
--%>
        <%-- Liste des abscences --%>
<%--    <a class="nav-item" href="${pageContext.request.contextPath}/do/missingList"> Les abscences </a>--%>
<%--
    <a class="nav-item" href="${pageContext.request.contextPath}/do/missingEdit"> Modifier les abscences </a>
--%>
</nav>