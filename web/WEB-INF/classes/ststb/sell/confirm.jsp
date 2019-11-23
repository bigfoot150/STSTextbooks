<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm</title>
</head>
<body>
    <p>Please confirm the below information for your new listing.</p>
    <p>
        ID: ${helper.data.itemid}
        <br>
        Title: ${helper.data.title}
        <br>
        Author: ${helper.data.author}
        <br>
        Description: ${helper.data.description}
        <br>
        ISBN13: ${helper.data.isbn13}
        <br>
        ISBN10: ${helper.data.isbn10}
        <br>
        Price: ${helper.data.price}
        <br>
        Shipping Cost: ${helper.data.shipping_cost}
        <br>
        Quantity: ${helper.data.quantity}
    </p>
    <p>
        <form method="POST" action="Controller">
            <input type="submit" name="selleditButton"
                   value="Edit">
            <input type="submit" name="sellprocessButton"
                   value="Process">
        </form>
    </p>
</body>
</html>
