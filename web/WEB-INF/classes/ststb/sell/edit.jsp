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
    <table>
        <tr>
            <td>Item ID</td>
            <td><input type="text" name="itemid" value="${helper.data.itemid}"></td>
            <td>${helper.errors.itemid}</td>
        </tr>
        <tr>
            <td>Title</td>
            <td><input type="text" name="title" value="${helper.data.title}"></td>
            <td>${helper.errors.title}</td>
        </tr>
        <tr>
            <td>Author</td>
            <td><input type="text" name="author" value="${helper.data.author}"></td>
            <td>${helper.errors.author}</td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input type="text" name="description" value="${helper.data.description}"></td>
            <td>${helper.errors.description}</td>
        </tr>
        <tr>
            <td>ISBN13</td>
            <td><input type="text" name="isbn13" value="${helper.data.isbn13}"></td>
            <td>${helper.errors.isbn13}</td>
        </tr>
        <tr>
            <td>ISBN10</td>
            <td><input type="text" name="isbn10" value="${helper.data.isbn10}"></td>
            <td>${helper.errors.isbn10}</td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="text" name="price" value="${helper.data.price}"></td>
            <td>${helper.errors.price}</td>
        </tr>
        <tr>
            <td>Shipping Cost</td>
            <td><input type="text" name="shipping_cost" value="${helper.data.shipping_cost}"></td>
            <td>${helper.errors.shipping_cost}</td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="text" name="quantity" value="${helper.data.quantity}"></td>
            <td>${helper.errors.quantity}</td>
        </tr>
    </table>
    <br>
    <br>
    <input type="submit" name="sellconfirmButton" value="Submit">
    </form>
</p>

</body>
</html>