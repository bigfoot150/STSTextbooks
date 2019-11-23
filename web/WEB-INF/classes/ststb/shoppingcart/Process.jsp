<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Process Page</title>
    <link rel="stylesheet" type="text/css" href="../../catalogue.css">
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
            Thank you for your purchase. However, since your
            credit card info and personal data were never
            collected, it will be difficult to bill you and send
            you your merchandise.
        <p>
            Please return again when someone has completed the
            rest of this application.
    </div>
    <div class="layout" id="bottom">

        <p>
            You ordered ${helper.cart.count} items for a total bill
            of ${helper.cart.totalAsCurrency}.
        </p>
            <form method="post" action="Controller">
        <p>
            <input type="submit" name="emptyCart"
                   value="Continue Shopping">
        </p>
            </form>
    </div>
</div>
</body>
</html>



