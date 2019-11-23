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
            <input type="hidden" name="email_error_message" value="" >
            <input type="hidden" name="password_error_message" value="" >
            <table>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" value="${helper.user.email}"></td>
                    <td>${helper.user.email_error_message}</td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><input type="text" name="password" value="${helper.user.password}"></td>
                    <td>${helper.user.password_error_message}</td>
                </tr>
            </table>

             <input type="submit" name="loginConfirmButton" value="Login">
             <input type="submit" name="signupButton" value="Sign Up">
        </form>
    </body>
</html>
