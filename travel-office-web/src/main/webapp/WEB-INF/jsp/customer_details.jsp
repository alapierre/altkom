<%-- 
    Document   : customer_details
    Created on : 2014-02-21, 10:12:50
    Author     : altkom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Travel Office :: Dane klienta</title>
    </head>
    <body>
        <h1>${customer.name}</h1>
        
        <form:form commandName="customer">
            Imię i nazwisko<br/>
            <form:input path="name"/><br/>
            Address:<br/>
            <form:input path="address"/><br/>
            <form:button>Zapisz</form:button>
        </form:form>
        
    </body>
</html>
