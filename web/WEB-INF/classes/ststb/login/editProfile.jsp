<%-- 
    Document   : editProfile
    Created on : Nov 11, 2019, 11:11:49 PM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile</title>
    </head>
    <body>
        <h1>Profile Edit</h1>
        <h2>${helper.user.misc_error_message}</h2>
            <form method="POST" action="Controller">
            First Name:        <input type="text" name="first_name" value="${helper.user.first_name}"> ${helper.errors.first_name}<br>
            Last  Name:        <input type="text" name="last_name" value="${helper.user.last_name}"> ${helper.errors.last_name}<br>
            Primary Address:   <input type="text" name="primary_address" value="${helper.user.primary_address}"> ${helper.errors.primary_address}<br>
            City:              <input type="text" name="city" value="${helper.user.city}"> ${helper.errors.city}<br>
            State:             <input type="text" name="state_abbr" value="${helper.user.state_abbr}"> ${helper.errors.state_abbr}<br>
            Zip Code:          <input type="text" name="zip_code" value="${helper.user.zip_code}"> ${helper.errors.zip_code} <br>
            Phone:             <input type="text" name="phone" value="${helper.user.phone}"> ${helper.errors.phone} <br>
            User Name:         <input type="text" name="username" value="${helper.user.username}"> ${helper.errors.username} ${helper.user.username_error_message} <br>
                               <input type="hidden" name="email" value="${helper.user.email}">
                               <input type="hidden" name="password" value="${helper.user.password}">
            <input type="hidden" name="username_error_message" value="">
            <input type="hidden" name="misc_error_message"     value="">                   
            <input type="submit" name="updateProfileButton" value="Update">
            <input type="submit" name="processLoginButton" value="Cancel">
        </form>
        
    </body>
</html>
