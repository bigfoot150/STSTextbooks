<%-- 
    Document   : editResetPassword
    Created on : Nov 25, 2019, 2:51:14 PM
    Author     : Jason
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>edit reset password</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        <h1>Reset Password</h1>
        <p>Enter the email for your account.</p>
        ${helper.user.email_error_message}
        <form method="POST" action="Controller" target="iframe_main">
            Email: <input style="width: 300px" type="text"   name="email" value=""><br> 
                   <input style="width: 100px" type="submit" name="ConfirmResetPasswordButton" value="Request reset">
                   <input style="width: 100px" type="submit" name="loginButton" value="Cancel">

        </form>
        
    </body>
</html>
