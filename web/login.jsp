<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="refresh" content="10" charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body class="quotes">
        ${helper.user.username}
    
<div style="text-align: right">
    
    <form id="post" action="ststb/Controller" method="post" target="iframe_main"></form>
    <form id="get" action="ststb/Controller" method="get" target="iframe_main"></form>
    
   <!-- <form method="POST" action="ststb/Controller" target="iframe_main"> -->
        <input style="width: 110px" type="submit" name="loginButton" value="Sign In" form="post">
        <input style="width: 110px" type="submit" name="signupButton" value="Sign Up" form="post"><br>
        <input style="width: 110px" type="submit" name="editResetPasswordButton" value="Reset Password" form="post">
   <!-- </form> 
     <form action="Controller" method="get"> -->
            <input style="width: 110px" type="submit" name="userSignOutButton" value="Sign Out" form="get">
    <!--    </form> -->
</div>
</body>
</html>