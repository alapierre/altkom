<%-- 
    Document   : display-customers
    Created on : 2014-02-21, 13:19:06
    Author     : altkom
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Travel Office :: Lista Klientów</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <h1>Klienci w systemie</h1>

            <table border="1">
                <thead> 
                    <th>ID</th>
                    <th>Imię i nazwisko</th> 
                    <th>Adres</th>
                    <th>Email</th>
                </thead> 
            <c:forEach items="${customers}" var="customer">
                <tr>
                    <td>${customer.id}</td>
                    <td><a href="customer_details.htm?id=${customer.id}">${customer.name}</a></td>
                    <td>${customer.address}</td>
                    <td>${customer.email}</td>
                </tr>

            </c:forEach>
            </table>

            <sec:authorize ifAnyGranted="ROLE_ADMIN">
                <br/><input type="button" value="Dodaj klienta" onclick="location.href='customer_details.htm?id=0'"/> 
            </sec:authorize>
        </div>
    </body>
</html>
