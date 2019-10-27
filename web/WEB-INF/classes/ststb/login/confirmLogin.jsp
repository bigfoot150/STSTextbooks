<%-- 
    Document   : loginConfirm
    Created on : Oct 25, 2019, 1:13:44 PM
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
        <p>Login Confirm</p>
        
        email:    ${helper.userData.email} <br>
        password: ${helper.userData.password}<br>
        id:       ${helper.errors.id}<br>
        username: ${helper.errors.username} <br>
        primary_address:   ${helper.errors.primary_address}<br>
        secondary_address: ${helper.errors.secondary_address} <br>
        city:     ${helper.errors.city}<br>       
        state:    ${helper.errors.state_abbr} <br>
        zip_code: ${helper.errors.zip_code}<br>       
        phone:    ${helper.errors.phone} <br>
        
      <form method="POST" action="Controller">
            <input type="submit" name="editLoginButton" value="Edit">
            <input type="submit" name="loginButton" value="Process">
          
      </form>
        
    </body>
</html>
