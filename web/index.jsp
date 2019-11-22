
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Student to Student Textbooks</title>
    <link rel="stylesheet" href="styles.css">
  </head>
  <body>


  <table style="border: 1px solid black; width: 100%; height: 100%; vertical-align: center; text-align: center">
<%--    Row 1--%>
    <tr style="border: 1px solid black; height: 5%" >
      <td rowspan="5" style="width: 20%"></td>
      <td style="width: 60%; padding-bottom: 0; vertical-align: bottom">
        <h1 style="margin-bottom: 1px">StudentToStudentTextbooks.com</h1>
      </td>
      <td style="width: 20%;">
        <iframe style="height:75px; border: 1px solid black; align-text: center" name="iframe_login" src="login.jsp"></iframe>
      </td>
    </tr>
<%--  Row 2--%>
    <tr style="height: 5%">

      <td>Search Bar Goes Here</td>
      <td rowspan="4">Ads or something else goes here</td>
    </tr>
<%--  Row 3--%>
    <tr style="height: 5%">
      <td>
        <p>
          <a href="ststb/Controller" target="iframe_main">Buy a Book</a>
          <a href="ststb/Controller" target="iframe_main">Sell a Book</a>
          <a href="faq.html" target="iframe_main">FAQ</a>
          <a href="help.html" target="iframe_main">Help</a>
          <a href="ststb/Controller" target="iframe_main">Shopping Cart</a>
      </p>
      </td>
    </tr>
  <%--  Row 4--%>
    <tr style="height: 75%">
      <td>
        <iframe style="border: 1px solid black; width: 75%; height: 75%;" name="iframe_main" src="welcome.html"></iframe>
      </td>
    </tr>
  <%--  Row 5--%>
    <tr style="height: 10%">
      <td>Other Links Go Here</td>
    </tr>
  </table>
  </body>
</html>
