<%-- 
    Document   : viewListings
    Created on : Nov 29, 2019, 9:07:20 AM
    Author     : NLennon
--%>

<%@page import="java.io.*,java.util.*,java.sql.*"%>
<%@page import="javax.servlet.http.*,javax.servlet.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>My Listings</title>
    </head>
    <body>
        <%--Since we don't have a dedicated server, the username/password have to be changed
        to your working version of MySQL to see the results of this transaction.--%>
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/ststb?autoReconnect=true&useSSL=false"
                           user="root" password="root" />
        
        <sql:query dataSource="${snapshot}" var="result">
            SELECT * FROM catalogueItem
            WHERE userId = "${helper.user.email}";        
        </sql:query>
        
        <h1>My Listings</h1>
        <table border="1">
            <tr>
                <th>Author</th>
                <th>Title</th>
                <th>Description</th>
                <th>ISBN-13</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
            
            <c:forEach var="row" items="${result.rows}">
                <tr>
                    <td><c:out value="${row.author}" /></td>
                    <td><c:out value="${row.title}" /></td>
                    <td><c:out value="${row.description}" /></td>
                    <td><c:out value="${row.isbn13}" /></td>
                    <td><c:out value="${row.quantity}" /></td>
                    <td><c:out value="${row.price}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
