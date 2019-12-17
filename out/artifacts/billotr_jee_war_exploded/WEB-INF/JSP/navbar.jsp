<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    .nav-item {
        color: #ff7246;
        margin-right: 6px;
        text-decoration: none;
        font-weight: 700;
        font-size: 26px;
    }
    .nav-item:hover {
        color: #c657ff;
    }
    .nav-container {
        width: 100%;
        text-align: center;
        margin-bottom: 24px;
    }
</style>
<nav class="nav-container">
        <%-- Liste des étudiants --%>
    <a class="nav-item" href="${pageContext.request.contextPath}/do/index"> Accueil </a>
        <%-- Liste de notes --%>
    <a class="nav-item" href="${pageContext.request.contextPath}/do/marksList"> Consulter les notes </a>
    <a class="nav-item" href="${pageContext.request.contextPath}/do/marksEdit"> Modifier les notes </a>
        <%-- Liste des abscences --%>
    <a class="nav-item" href="${pageContext.request.contextPath}/do/missingList"> Consulter les abscences </a>
    <a class="nav-item" href="${pageContext.request.contextPath}/do/missingEdit"> Modifier les abscences </a>
</nav>