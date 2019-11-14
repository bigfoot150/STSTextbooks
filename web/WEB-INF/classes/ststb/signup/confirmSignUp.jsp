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
        First Name: ${helper.userData.first_name}<br>
        last Name: ${helper.userData.last_name}<br>
        Primary Address: ${helper.userData.primary_address}<br>
        Secondary Address: ${helper.userData.secondary_address}<br>       
        City: ${helper.userData.city}<br>
        State: ${helper.userData.state_abbr}<br>
        Zip Code: ${helper.userData.zip_code}<br>
        Phone: ${helper.userData.phone}<br>
        User Name: ${helper.userData.username}<br>
        Email: ${helper.userData.email}<br>    
        Password: ${helper.userData.password}<br>
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
