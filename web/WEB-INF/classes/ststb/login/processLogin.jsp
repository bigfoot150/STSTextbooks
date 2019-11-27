<%-- 
    Document   : processLogin
    Created on : Oct 26, 2019, 11:16:48 AM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Process Login</title>
    </head>
    <body>
        <h3>Welcome ${helper.user.username}!</h3>
        
        <form action="Controller" method="post">
            <input type="submit" name="editProfileButton" value="Edit Profile">
        </form> <br>
              
        <form action="Controller" method="get">
            <input type="submit" name="userSignOutButton" value="Sign Out">
        </form>
  
        
<%--        <p><strong>Current Bean dump for development and testing</strong></p>--%>
<%--        ${helper.user.id} <br>--%>
<%--        ${helper.user.email} <br>--%>
<%--        ${helper.user.password} <br>--%>
<%--        ${helper.user.first_name} <br> --%>
<%--        --%>
<%--        <p><strong>Current user profiles dump for development and testing</strong></p>--%>
<%--           <%@ taglib uri="http://java.sun.com/jsp/jstl/core" --%>
<%--             prefix="core" %>--%>
<%--      <core:forEach var="row" items="${database}">--%>
<%--          ${row.id} <br>--%>
<%--          ${row.email} <br>--%>
<%--          ${row.password} <br>--%>
<%--          ${row.username} <br>--%>
<%--          ${row.first_name} <br>--%>
<%--          ${row.last_name} <br>--%>
<%--          ${row.primary_address} <br>--%>
<%--          ${row.city} <br>--%>
<%--          ${row.state_abbr} <br>--%>
<%--          ${row.zip_code} <br>--%>
<%--          ${row.phone} <br>--%>
<%--          <br><br>--%>
<%--      </core:forEach>--%>
      
        
    </body>
</html>
