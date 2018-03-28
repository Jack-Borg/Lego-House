<%-- 
    Document   : customerpage
    Created on : Aug 22, 2017, 2:33:37 PM
    Author     : kasper
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>
    </head>
    <body>
        <h1>Hello <%=request.getParameter("username")%> </h1>
        You are now logged in as a customer of our wonderful site.
        <form name="createorder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="createorder">
            Height:<br>
            <input type="number" name="height" min="6" required="">
            <br>
            Length:<br>
            <input type="number" name="length" min="8" required="">
            <br>
            Width:<br>
            <input type="number" name="width" min="8" required="">
            <br>
            <input type="submit" value="Submit">
        </form>
        <h1>
        </h1>
        <form name="orderpage" action="FrontController" method="POST">
            <input type="hidden" name="command" value="orderpage">
            <input type="submit" value="my orders">
        </form>
    </body>
</html>
