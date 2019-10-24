<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Sell A Book</title>
</head>
<p>
<p>
    Sell A Book Below
</p>
<p>
    <form method="POST" action="Controller">

     ISBN13
    <input type="text" name="isbn13" value="${helper.data.isbn13}">
    ${helper.errors.isbn13}
    <br>
    ISBN10
    <input type="text" name="isbn10" value="${helper.data.isbn10}">
    ${helper.errors.isbn10}
    <br>
    userid
    <input type="text" name="userid" value="${helper.data.userid}">
    ${helper.errors.userid}
    <br>
    Date
    <input type="text" name="date_created" value="${helper.data.date_created}">
    ${helper.errors.date_created}
    <br>
    Author
    <input type="text" name="author" value="${helper.data.author}">
    ${helper.errors.author}
    <br>
    Title
    <input type="text" name="title" value="${helper.data.title}">
    ${helper.errors.title}
    <br>
    Price
    <input type="text" name="price" value="${helper.data.price}">
    ${helper.errors.price}
    <br>
    Shipping Cost
    <input type="text" name="shipping_cost" value="${helper.data.shipping_cost}">
    ${helper.errors.shipping_cost}
    <br>
    Quantity
    <input type="text" name="quantity" value="${helper.data.quantity}">
    ${helper.errors.quantity}
    <br>
    <br>
    <input type="submit" name="confirmButton" value="Submit">
    </form>
</p>

</body>
</html>