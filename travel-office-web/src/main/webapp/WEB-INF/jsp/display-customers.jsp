<%-- 
    Document   : display-customers
    Created on : 2014-02-21, 13:19:06
    Author     : altkom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Travel Office :: Lista Klientów</title>
    </head>
    <body>
        <h1>Klienci w systemie</h1>
        
        <table border="1">
        <c:forEach items="${customers}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td><a href="customer_details.htm?id=${customer.id}">${customer.name}</a></td>
                <td>${customer.address}</td>
                <td>${customer.email}</td>
            </tr>
            
        </c:forEach>
        </table>
    </body>
</html>
