<%--
  Created by IntelliJ IDEA.
  User: izio
  Date: 17/01/2020
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="isCreation" class="java.lang.Boolean" scope="request"/>

<h2><%= isCreation? "Création d'un module": "Edition d'un module" %></h2>
<form method="post">
    <label>
        Nom :
        <input name="name" type="text" placeholder="MI5"/>
    </label>

    <label>
        Coefficiant :
        <input name="coeff" type="number" placeholder="25"/>
    </label>

    <button type="submit"><%= isCreation? "Créer": "Modifier" %></button>

</form>
