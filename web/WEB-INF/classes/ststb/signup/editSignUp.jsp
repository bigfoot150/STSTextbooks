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
            First Name:        <input type="text" name="first_name" value="${helper.userData.first_name}"> ${helper.errors.first_name}<br>
            Last  Name:        <input type="text" name="last_name" value="${helper.userData.last_name}"> ${helper.errors.last_name}<br>
            Primary Address:   <input type="text" name="primary_address" value="${helper.userData.primary_address}"> ${helper.errors.primary_address}<br>
            Secondary Address: <input type="text" name="secondary_address" value="${helper.userData.secondary_address}"> ${helper.errors.secondary_address}<br>           
            City:              <input type="text" name="city" value="${helper.userData.city}"> ${helper.errors.city}<br>
            State:             <input type="text" name="state_abbr" value="${helper.userData.state_abbr}"> ${helper.errors.state_abbr}<br>
            Zip Code:          <input type="text" name="zip_code" value="${helper.userData.zip_code}"> ${helper.errors.zip_code} <br>
            Phone:             <input type="text" name="phone" value="${helper.userData.phone}"> ${helper.errors.phone} <br>
            User Name:         <input type="text" name="username" value="${helper.userData.username}"> ${helper.errors.username} ${helper.userData.username_error_message}<br>           
            Email:             <input type="text" name="email" value="${helper.userData.email}"> ${helper.errors.email} ${helper.userData.email_error_message}<br>
            Password:          <input type="text" name="password" value="${helper.userData.password}"> ${helper.errors.password}<br>
            <%--
            Confirm Password:  <input type="text" name="confirm_password" value="${helper.userData.confirm_password}">
            --%>
            <input type="hidden" name="email_error_message" value="">
            <input type="hidden" name="username_error_message" value="">
                               
            <input type="submit" name="userConfirmButton" value="Sign Up">
            <input type="submit" name="loginButton" value="Login">
        </form>
    </body>
</html>
