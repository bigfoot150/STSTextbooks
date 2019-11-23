<%-- 
    Document   : confirmSignUp
    Created on : Oct 26, 2019, 9:31:38 AM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Sign Up</title>
    </head>
    <body>
        <p>Confirm that the entries are correct.</p>
        <p>Please confirm the below information for your new listing.</p>
    <p>
        First Name: ${helper.user.first_name}<br>
        Last Name: ${helper.user.last_name}<br>
        Primary Address: ${helper.user.primary_address}<br>

        City: ${helper.user.city}<br>
        State: ${helper.user.state_abbr}<br>
        Zip Code: ${helper.user.zip_code}<br>
        Phone: ${helper.user.phone}<br>
        User Name: ${helper.user.username}<br>
        Email: ${helper.user.email}<br>
        Password: ${helper.user.password}<br>
    </p>
    <p>
        <form method="POST" action="Controller">
            <input type="submit" name="userEditButton"
                   value="Edit">
            <input type="submit" name="userProcessButton"
                   value="Process">
        </form>
    </p>
    </body>
</html>
