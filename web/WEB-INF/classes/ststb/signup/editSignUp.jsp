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
        <title>Sign Up</title>
    </head>
    <body>
        <p>Enter your information below and then click the submit button.<br>
            You will then be given a chance to confirm the information that was entered.</p><br>
        
        <form method="POST" action="Controller">
        <table>
            <tr>
                <td>First Name:</td>
                <td><input type="text" name="first_name" value="${helper.user.first_name}"></td>
                <td>${helper.errors.first_name}</td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><input type="text" name="last_name" value="${helper.user.last_name}"></td>
                <td>${helper.errors.last_name}</td>
            </tr>
            <tr>
                <td>Primary Address:</td>
                <td> <input type="text" name="primary_address" value="${helper.user.primary_address}"></td>
                <td>${helper.errors.primary_address}</td>
            </tr>
            <tr>
                <td>City:</td>
                <td><input type="text" name="city" value="${helper.user.city}"></td>
                <td>${helper.errors.city}</td>
            </tr>
            <tr>
                <td>State:</td>
                <td><input type="text" name="state_abbr" value="${helper.user.state_abbr}"></td>
                <td>${helper.errors.state_abbr}</td>
            </tr>
            <tr>
                <td>Zip Code:</td>
                <td><input type="text" name="zip_code" value="${helper.user.zip_code}"></td>
                <td>${helper.errors.zip_code}</td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><input type="text" name="phone" value="${helper.user.phone}"></td>
                <td>${helper.errors.phone} </td>
            </tr>
            <tr>
                <td>User Name:</td>
                <td><input type="text" name="username" value="${helper.user.username}"></td>
                <td>${helper.errors.username} ${helper.user.username_error_message}</td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" value="${helper.user.email}"></td>
                <td> ${helper.errors.email} ${helper.user.email_error_message}</td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="text" name="password" value="${helper.user.password}"></td>
                <td> ${helper.errors.password}</td>
            </tr>
<%--            <tr>--%>
<%--                <td>Confirm Password:</td>--%>
<%--                <td><input type="text" name="confirm_password" value="${helper.userData.confirm_password}"></td>--%>
<%--                <td> ${helper.errors.password}</td>--%>
<%--            </tr>--%>
        </table>
            <input type="hidden" name="email_error_message" value="">
            <input type="hidden" name="username_error_message" value="">
                               
            <input type="submit" name="userConfirmButton" value="Sign Up">
            <input type="submit" name="loginButton" value="Login">
        </form>
    </body>
</html>
