<%-- 
    Document   : processLogin
    Created on : Oct 26, 2019, 11:16:48 AM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Welcome ${helper.userData.username}</h3>
        
        ${helper.userData.id} <br>
        ${helper.userData.email} <br>
        ${helper.userData.password} <br>
        <%--
           <%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
             prefix="core" %>
      <core:forEach var="row" items="${database}">
          ${row.id} <br>
          ${row.email} <br>
          ${row.password} <br>
          ${row.username} <br>
          ${row.first_name} <br>
          ${row.last_name} <br>
          ${row.primary_address} <br>
          ${row.secondary_address} <br>
          ${row.state_abbr} <br>
          ${row.zip_code} <br>
          ${row.phone} <br>
         
      </core:forEach>
        --%>
        
    </body>
</html>
