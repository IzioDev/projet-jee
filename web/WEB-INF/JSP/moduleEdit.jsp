<%--
  Created by IntelliJ IDEA.
  User: izio
  Date: 17/01/2020
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="isCreation" class="java.lang.Boolean" scope="request"/>
<jsp:useBean id="module" class="models.Module" scope="request"/>



<h2><%= isCreation? "Création d'un module": "Edition d'un module" %></h2>
<form method="post">
    <label>
        Nom :
        <input name="name" type="text" value="<%= !isCreation? module.getNom() : "" %>" placeholder="MI5"/>
    </label>

    <%
        if (!isCreation) {
    %>
        <input name="id" type="hidden" value="<%= module.getId() %>">
    <%
        }
    %>

<%--    <label>--%>
<%--        Coefficiant :--%>
<%--        <input name="coeff" type="number" placeholder="25"/>--%>
<%--    </label>--%>

    <button type="submit"><%= isCreation? "Créer": "Modifier" %></button>

</form>
