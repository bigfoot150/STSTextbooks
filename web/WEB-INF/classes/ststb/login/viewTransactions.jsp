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
        <title>My Transactions</title>
    </head>
    <body>
        <%--Since we don't have a dedicated server, the username/password have to be changed
        to your working version of MySQL to see the results of this transaction.--%>
        <sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                           url="jdbc:mysql://localhost:3306/ststb?autoReconnect=true&useSSL=false"
                           user="root" password="root" />
        
        <sql:query dataSource="${snapshot}" var="result">
            SELECT * FROM shoppingcart
            WHERE email = "${helper.user.email}";        
        </sql:query>
        
        <h1>My Listings</h1>
        <table border="1">
            <tr>
                <th>Account Number</th>
                <th>Email</th>
                <th>Quantity</th>
                <th>Total</th>
            </tr>
            
            <c:forEach var="row" items="${result.rows}">
                <tr>
                    <td><c:out value="${row.accountNumber}" /></td>
                    <td><c:out value="${row.email}" /></td>
                    <td><c:out value="${row.count}" /></td>
                    <td><c:out value="${row.total}" /></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
