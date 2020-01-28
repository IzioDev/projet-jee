<%@ page import="models.Groupe" %><%--
  Created by IntelliJ IDEA.
  User: izio
  Date: 17/12/2019
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="isCreation" class="java.lang.Boolean" scope="request"/>
<jsp:useBean id="student" class="models.Etudiant" scope="request"/>
<jsp:useBean id="groups" type="java.util.List<models.Groupe>" scope="request"/>

<style>
    .form-group {
        display: block;
        margin-bottom: 12px;
    }
</style>

<h2><%= isCreation? "Création d'un étudiant": "Edition d'un étudiant" %></h2>
<form method="post" accept-charset="UTF-8">
    <label class="form-group">
        Prénom :
        <input name="firstname" type="text" required value="<%= !isCreation? student.getPrenom() : "" %>" placeholder="Francis"/>
    </label>

    <label class="form-group">
        Nom :
        <input name="lastname" type="text" required value="<%= !isCreation? student.getNom() : "" %>" placeholder="BRUNET-MANQUAT"/>
    </label>

    <label class="form-group">
        Groupe :
        <select required name="groupId">
            <%
                for (Groupe group: groups) {
                  if (!isCreation && student.getGroupe().getId().equals(group.getId())) {
                  %>
                    <option selected="selected" value="<%=group.getId()%>">
                        <%=group.getNom()%>
                    </option>
            <%
                  } else {
            %>
                    <option value="<%=group.getId()%>">
                        <%=group.getNom()%>
                    </option>
            <%
                    }}
            %>
        </select>
    </label>

    <label class="form-group">
        Nom d'abscence(s) :
        <input name="nbAbscence" min="0" type="number" required value="<%= !isCreation? student.getNbAbsences() : 0 %>" placeholder="0"/>
    </label>

    <%
        if (!isCreation) {
    %>
    <input name="id" type="hidden" value="<%= student.getId() %>">
    <%
        }
    %>

    <button type="submit" class="btn btn-success"><%= isCreation? "Créer": "Modifier" %></button>

</form>