<%--
  Created by IntelliJ IDEA.
  User: izio
  Date: 14/02/2020
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="etudiant" class="models.Etudiant" scope="request"/>
<style>
    .form-group {
        display: block;
        margin-bottom: 12px;
    }
</style>


<h2>Ajout d'une note pour <%= etudiant.getPrenom() + " " + etudiant.getNom() %></h2>
<form method="post" accept-charset="UTF-8">
    <label class="form-group">
        Note :
        <input name="note" min="0" step="0.25" max="20" type="number" required value="10" placeholder="0"/>
    </label>

    <input name="id" type="hidden" value="<%= etudiant.getId() %>">

    <button type="submit" class="btn btn-success">Ajouter</button>
</form>
