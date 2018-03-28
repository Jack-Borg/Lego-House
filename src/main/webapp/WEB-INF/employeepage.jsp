<%-- 
    Document   : employeepage.jsp
    Created on : Aug 24, 2017, 6:31:57 AM
    Author     : kasper
--%>

<%@page import="FunctionLayer.OrderDisplay"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        ArrayList<OrderDisplay> orders = (ArrayList<OrderDisplay>) request.getAttribute("orders");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>

        <h1>Hello <%=request.getAttribute("username")%> </h1>
        <form name="sentorder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="sentorder">
            <table>
                <thead>
                    <tr>
                        <th scope="col">order number</th>
                        <th scope="col">user id</th>
                        <th scope="col">1x2</th>
                        <th scope="col">2x2</th>
                        <th scope="col">2x4</th>
                        <th scope="col">price</th>
                        <th scope="col">sent</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (OrderDisplay o : orders)
                        {
                            out.println("<tr>");
                            out.println("<td>" + o.getId_order() + "</td>");
                            out.println("<td>" + o.getId_user() + "</td>");
                            out.println("<td>" + o.getAmount1() + "</td>");
                            out.println("<td>" + o.getAmount2() + "</td>");
                            out.println("<td>" + o.getAmount4() + "</td>");
                            out.println("<td>" + o.getPrice() + "</td>");
                            out.println("<td>"
                                    + "<select name = " + o.getId_order() + ">"
                                    + "<option value='" + o.isSent() + "'>"
                                    + o.isSent()
                                    + "</option>"
                                    + "<option value='" + !o.isSent() + "'>"
                                    + !o.isSent()
                                    + "</option>"
                                    + "</select>"
                                    + "</td>");
                            out.println("</tr>");
                        }
                    %>
                </tbody>
            </table>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
