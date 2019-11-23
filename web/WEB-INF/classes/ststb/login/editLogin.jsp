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
  
        <form method="POST" action="Controller">
            
             ${helper.userData.email_error_message}
             <input type="hidden" name="email_error_message" value="" > 
             ${helper.errors.email}
             email: <input type="text" name="email" value="${helper.userData.email}"> <br>
            
             ${helper.userData.password_error_message}
              <input type="hidden" name="password_error_message" value="" >
             ${helper.errors.password}
             password: <input type="text" name="password" value="${helper.userData.password}"> <br>
            
             <input type="submit" name="loginConfirmButton" value="Login">
             <input type="submit" name="signupButton" value="Sign Up">
        </form>
    </body>
</html>
