<%-- 
    Document   : changePassword
    Created on : Nov 23, 2019, 11:11:49 PM
    Author     : NLennon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
    </head>
    <body>
        <h1>Change Password</h1>
        <h2>${helper.user.misc_error_message}</h2>
            <form method="POST" action="Controller">
                <table>
                    <tr>
                        <td>User Name:</td>
                        <td><input type="text" name="username" value="${helper.user.username}"></td> 
                        <td>${helper.errors.username} ${helper.user.username_error_message} </td>
                    </tr>
                    <tr>
                        <td>Old Password:</td>
                        <td><input type="text" name="oldPassword" value="${helper.user.password}"></td>
                        <td>${helper.errors.password} ${helper.user.password_error_message}</td>
                    </tr>    
                    <tr>
                        <td>New Password:</td>
                        <td><input type="text" name="newPassword" value="${helper.user.password}"></td>
                        <td>${helper.errors.password} ${helper.user.password_error_message}</td>
                    </tr>    
             </table>
            <input type="hidden" name="username_error_message" value="">
            <input type="hidden" name="misc_error_message"     value="">                   
            <input type="submit" name="updatePassword" value="Update">
            <input type="submit" name="processLoginButton" value="Cancel">
        </form>
    </body>
</html>
