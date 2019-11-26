<%-- 
    Document   : resetPasswordEdit
    Created on : Nov 25, 2019, 3:02:22 PM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>reset password</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        <h1>Reset Password</h1>
        <p>Enter your new password below.<br>
            It should be 5-10 characters in length.
        </p>
        <form method = "POST" action="Controller">
            <input type="text" name="password" value="">${helper.errors.password}
            <input type="submit" name="processResetPasswordButton" value="Submit">
            <input type="submit" name="loginButton" value="Cancel">
        </form>
    </body>
</html>
