<%--
  Created by IntelliJ IDEA.
  User: Nick
  Date: 10/23/2019
  Time: 3:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm</title>
</head>
<body>
    <p>Please confirm the below information for your new listing.</p>
    <p>
        ISBN13: ${helper.data.isbn13}
        <br>
        ISBN10: ${helper.data.isbn10}
        <br>
        userid: ${helper.data.userid}
        <br>
        Date: ${helper.data.date_created}
        <br>
        Author: ${helper.data.author}
        <br>
        Title: ${helper.data.title}
        <br>
        Price: ${helper.data.price}
        <br>
        Shipping Cost: ${helper.data.shipping_cost}
        <br>
        Quantity: ${helper.data.quantity}
    </p>
    <p>
        <form method="POST" action="Controller">
            <input type="submit" name="editButton"
                   value="Edit">
            <input type="submit" name="processButton"
                   value="Process">
        </form>
    </p>
</body>
</html>
