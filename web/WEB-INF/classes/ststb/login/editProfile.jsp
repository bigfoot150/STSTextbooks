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
        <h1>Edit Profile</h1>
        <h2>${helper.user.misc_error_message}</h2>
            <form method="POST" action="Controller">
                <table>
                    <tr>       
                        <td>First Name:</td> 
                        <td><input type="text" name="first_name" value="${helper.user.first_name}"></td> 
                        <td>${helper.errors.first_name}</td>
                    </tr>
                    <tr>
                        <td>Last  Name:</td>       
                        <td><input type="text" name="last_name" value="${helper.user.last_name}"> </td>
                        <td>${helper.errors.last_name}</td>
                    </tr>   
                    <tr>
                        <td>Primary Address:</td>   
                        <td><input type="text" name="primary_address" value="${helper.user.primary_address}"></td>
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
                        <td>${helper.errors.phone}</td>
                    </tr>
                    <tr>
                        <td>User Name:</td>
                        <td><input type="text" name="username" value="${helper.user.username}"></td> 
                        <td>${helper.errors.username} ${helper.user.username_error_message} </td>
                    </tr>
                    <tr>    
                        <td>Password:</td>
                        <td><input type="text" name="password" value="${helper.user.password}"></td>
                        <td>${helper.errors.password} ${helper.user.password_error_message}</td>
                    </tr>    
             </table>
            <input type="hidden" name="email" value="${helper.user.email}"><br>
            <input type="hidden" name="username_error_message" value="">
            <input type="hidden" name="misc_error_message"     value="">                   
            <input type="submit" name="updateProfileButton" value="Update">
            <input type="submit" name="processLoginButton" value="Cancel">
               
        </form>
        
    </body>
</html>
