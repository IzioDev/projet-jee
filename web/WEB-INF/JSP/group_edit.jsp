<%--
  Created by IntelliJ IDEA.
  User: izio
  Date: 17/01/2020
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="isCreation" class="java.lang.Boolean" scope="request"/>
<jsp:useBean id="group" class="models.Groupe" scope="request"/>

<h2><%= isCreation? "Création d'un groupe": "Edition d'un groupe" %></h2>
<form method="post">
    <label>
        Nom :
        <input name="name" type="text" value="<%= !isCreation? group.getNom() : "" %>" placeholder="AW"/>
    </label>

    <%
        if (!isCreation) {
    %>
    <input name="id" type="hidden" value="<%= group.getId() %>">
    <%
        }
    %>

    <button type="submit"><%= isCreation? "Créer": "Modifier" %></button>

</form>
