<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="../../catalogue.css">
    <title>Save Cart</title>
</head>
<body>
<div class="layout" id="outer">
    <div class="layout" id="left">
        <table border>
            <core:forEach var="oneItem"
                          items="${helper.cart.items}">
            <tr>
                <td>${oneItem.itemid}
                <td>${oneItem.title}
                <td>${oneItem.price}
                    </core:forEach>
        </table>
    </div>
    <div class="layout" id="right">
        <p>
            Thank you for your interest. Your cart has been
            saved for future use. When you return, your cart
            will be waiting for you.
    </div>
    <div class="layout" id="bottom">
        <p>
            Currently, there are ${helper.cart.count} items for a total bill
            of ${helper.cart.totalAsCurrency}.
        </p>
            <form method="post" action="Controller">
        <p>
            <input type="submit" name="shop"
                   value="Continue Shopping">
            <input type="submit" name="processCart"
                   value="Process Cart">
            <input type="submit" name="emptyCart"
                   value="Empty Cart">
        </p>
        <p>
            <input type="submit" name="newUser"
                   value="New User">
        </p>
            </form>
    </div>
</div>
</body>
</html>



