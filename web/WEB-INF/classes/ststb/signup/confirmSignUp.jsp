<%-- 
    Document   : confirmSignUp
    Created on : Oct 26, 2019, 9:31:38 AM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Sign Up</title>
    </head>
    <body>
        <p>Please confirm the below information for your new listing.</p>
        <table>
            <tr>
                <td>First Name: </td>
                <td>${helper.user.first_name}</td>
            </tr>
            <tr>
                <td>Last Name: </td>
                <td>${helper.user.last_name}</td>
            </tr>
            <tr>
                <td>Primary Address: </td>
                <td>${helper.user.primary_address}</td>
            </tr>
            <tr>
                <td>City: </td>
                <td>${helper.user.city}</td>
            </tr>
            <tr>
                <td>State: </td>
                <td>${helper.user.state_abbr}</td>
            </tr>
            <tr>
                <td>Zip Code: </td>
                <td>${helper.user.zip_code}</td>
            </tr>
            <tr>
                <td>Phone: </td>
                <td>${helper.user.phone}</td>
            </tr>
            <tr>
                <td>User Name: </td>
                <td>${helper.user.username}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>${helper.user.email}</td>
            </tr>
            <tr>
                <td>Password: </td>
                <td>${helper.user.password}</td>
            </tr>
        </table>
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
