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
        <link href="css/bootstrap.min.css" rel="stylesheet">
    </head>
    <style>
        .error {color: red}
    </style>
    <body>
        <div class="container">
            <h1>${customer.name}</h1>

            id klienta = ${customer.id}

            <form:form commandName="customer" action="save_customer.htm">
                Imię i nazwisko <form:errors path="name" cssClass="error"/> <br/>
                <form:input path="name"/><br/>
                Address:<br/>
                <form:input path="address"/><form:errors path="address" cssClass="error"/> <br/>
                Email:<br/>
                <form:input path="email"/><form:errors path="email" cssClass="error"/> <br/>
                Kraj:<br/>
                <form:select  path="country.id">
                   <%-- <form:option value="0" label="--- Select ---"/> --%>
                    <form:options items="${countries}" itemLabel="name" itemValue="id" />
                </form:select><form:errors path="country.id" cssClass="error"/>

                <form:hidden id="id" path="id"></form:hidden>
                <br/><form:button>Zapisz</form:button> 
                <input type="button" value="Anuluj" onclick="location.href='display-customers.htm'"/> 
            </form:form>
        </div>
    </body>
</html>
