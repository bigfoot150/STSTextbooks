<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
           prefix="core" %>
<html>
<head>
    <meta charset="utf-8">
    <link href="../../catalogue.css" rel="stylesheet" type="text/css" >
    <title>Browse</title>
</head>
<body>
<div class="layout" id="outer">
    <div class="layout" id="left">
        <core:forEach var="oneItem" items="${allItems}">
            <form method='post' action="Controller">
                <p>
                    <input type='submit' name='viewItem'
                           value='View Item'>
                    <input type='hidden' name='itemid'
                           value='${oneItem.itemid}'>
                        ${oneItem.title}
            </form>
        </core:forEach>
    </div>
    <core:if test="${helper.item.itemid != null}">
        <div class="layout" id="right">
                ${helper.item.title}<hr>
                ${helper.item.description}<hr>
                ${helper.item.price}<hr>
            <form action="Controller" method="post">
                <p>
                    <input type="hidden" name="itemid"
                           value="${helper.item.itemid}">
                    <input type="submit" name="addCart"
                           value="Add To Cart">
                    <input type="reset">
            </form>
        </div>
    </core:if>
    <div class="layout" id="bottom">
        <form action="Controller" method="post">
            <p>
                <input type="submit" name="shoppingcartButton"
                       value="View Cart">
        </form>
    </div>
</div>
</body>
</html>
