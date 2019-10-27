<%-- 
    Document   : newjsp
    Created on : Oct 25, 2019, 11:26:16 AM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>editLogin</title>
    </head>
    <body>
        <h3>Enter your login information</h3>    
      <%--
        id:       ${helper.errors.id}<br>
        username: ${helper.errors.username} <br>
        primary_address:   ${helper.errors.primary_address}<br>
        secondary_address: ${helper.errors.secondary_address} <br>
        city:     ${helper.errors.city}<br>       
        state:    ${helper.errors.state_abbr} <br>
        zip_code: ${helper.errors.zip_code}<br>       
        phone:    ${helper.errors.phone} <br>
        email:    ${helper.errors.email} <br>
        password: ${helper.errors.password}<br>        
--%>
        <form method="POST" action="Controller">
            email: <input type="text" name="email" value="${helper.userData.email}"> <br>
            password: <input type="text" name="password" value="${helper.userData.password}"> <br>
                      <input type="submit" name="loginConfirmButton" value="login">
        </form>
    </body>
</html>
