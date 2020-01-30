<%@ page import="models.Module" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: izio
  Date: 17/01/2020
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="isCreation" class="java.lang.Boolean" scope="request"/>
<jsp:useBean id="group" class="models.Groupe" scope="request"/>
<jsp:useBean id="modules" type="java.util.List<models.Module>" scope="request"/>

<h2><%= isCreation? "Création d'un groupe": "Edition d'un groupe" %></h2>
<form method="post" accept-charset="UTF-8">
    <label>
        Nom :
        <input name="name" required type="text" value="<%= !isCreation? group.getNom() : "" %>" placeholder="AW"/>
    </label>

    <%
        if (!isCreation) {
    %>
    <input name="id" type="hidden" value="<%= group.getId() %>">
    <%
        }
    %>

    <%
        List<Module> groupModules = group.getModules();
        List<Module> otherModules = new ArrayList<>();

        for (Module module: modules) {

            boolean found = false;
            for(Module groupModule: groupModules) {
                if (groupModule.getId() == module.getId()) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                otherModules.add(module);
            }
        }

        for (Module groupModule: groupModules) {
    %>
        <input type="checkbox" checked id="module-<%=groupModule.getId()%>" name="module-<%=groupModule.getId()%>"/>
        <label for="module-<%=groupModule.getId()%>"><%=groupModule.getNom()%></label>
    <%
        }

        for (Module otherModule: otherModules) {
    %>
        <input type="checkbox" id="module-<%=otherModule.getId()%>" name="module-<%=otherModule.getId()%>"/>
        <label for="module-<%=otherModule.getId()%>"><%=otherModule.getNom()%></label>
    <%
        }
    %>

    <button type="submit" class="btn btn-success"><%= isCreation? "Créer": "Modifier" %></button>

</form>
