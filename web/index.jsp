
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
  <head>
    <title>Student to Student Textbooks</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
  </head>
  <body>


  <table style="border: 1px solid black; width: 100%; height: 100%; 
         vertical-align: center; text-align: center" scrolling="yes" >
<%--    Row 1--%>
<tr style="border: 1px solid black; height: 5%; background-color: #ccccff; "  >
      <td rowspan="5" style="width: 20%"></td>
      <td style="width: 60%; padding-bottom: 0; vertical-align: bottom; " >
        <h1 style="margin-bottom: 1px; ">StudentToStudentTextbooks.com</h1>
      </td>
      <td style="width: 20%;">
        <iframe style="height:75px; border: 0" name="iframe_login" src="login.jsp"></iframe>
      </td>
    </tr>
<%--  Row 2--%>
    <tr style="height: 5%">

      <td class="grey" ></td>
      <td style="background-color: #ccccff;" rowspan="4"></td>
    </tr>
<%--  Row 3--%>
    <tr style="height: 5%">
      <td class="blue">
        <p>
          <form method="POST" action="ststb/Controller" target="iframe_main">
            <input type="submit" name="buyButton"
                 value="Buy a Book">
            <input type="submit" name="selleditButton"
                   value="Sell a Book">
            <input type="submit" name="faqButton"
                   value="FAQ">
            <input type="submit" name="helpButton"
                   value="Help">
            <input type="submit" name="shoppingcartButton"
                   value="Shopping Cart">
            <input type="submit" name="aboutUsButton"
                   value="About Us">
          </form>
        </p>
      </td>
    </tr>
  <%--  Row 4--%>
    <tr style="height: 75%; background-color: gainsboro;">
      <td>
        <iframe style="border: 1px solid black; width: 75%; height: 75%; background-color: #ccccff;" name="iframe_main" src="welcome.html"></iframe>
      </td>
    </tr>
  <%--  Row 5--%>
    <tr style="height: 10%; background-color: #ccccff;">
      <td></td>
    </tr>
  </table>
  </body>
</html>
