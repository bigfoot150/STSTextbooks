<%-- 
    Document   : userHome
    Created on : Oct 26, 2019, 9:44:07 AM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>userHome</title>
    </head>
    <body>
        <h4>Welcome ${helper.userData.username}.</h4>
        <p>Display user sign up info from database <br>
            probably can remove and just use processLogin.jsp.<br>
        not currently being referenced.
        </p>

        
             <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
             prefix="core" %>
      <core:forEach var="row" items="${database}">
          ${row.id} <br>
          ${row.first_name} <br>
          ${row.last_name} <br>
          ${row.primary_address} <br>
          ${row.secondary_address} <br>
          ${row.city} <br>          
          ${row.state_abbr} <br>
          ${row.zip_code} <br>
          ${row.phone} <br>
          ${row.username} <br>       
      </core:forEach>
        
        
    </body>
</html>
