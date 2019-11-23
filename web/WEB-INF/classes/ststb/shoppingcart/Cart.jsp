<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<html>
<head>
    <meta charset="utf-8">
    <link href="${pageContext.request.contextPath}/catalogue.css"
          rel="stylesheet" type="text/css" >
    <title>View Cart</title>
</head>
<body>
<div class="layout" id="outer">
    <div class="layout" id="left">
        <table>
            <core:forEach var="oneItem"
                          items="${helper.cart.items}">
            <tr>
                <td>${oneItem.itemid}
                <td>${oneItem.title}
                <td>${oneItem.price}
                    </core:forEach>
        </table>
    </div>
    <div class="layout" id="bottom">
        <form method="post" action="Controller">
            <p>
                <input type="submit" name="buyButton"
                       value="Continue Shopping">
                <input type="submit" name="processCart"
                       value="Process Cart">
                <input type="submit" name="emptyCart"
                       value="Empty Cart">
        </form>
    </div>
</div>
</body>
</html>
