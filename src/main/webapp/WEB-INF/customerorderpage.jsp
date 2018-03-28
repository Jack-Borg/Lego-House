<%@page import="FunctionLayer.OrderDisplay"%>
<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
    ArrayList<OrderDisplay> orders = (ArrayList<OrderDisplay>)request.getAttribute("orders");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>customer order page</title>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th scope="col">order number</th>
                    <th scope="col">1x2</th>
                    <th scope="col">2x2</th>
                    <th scope="col">2x4</th>
                    <th scope="col">price</th>
                    <th scope="col">sent</th>
                </tr>
            </thead>
            <tbody>
                <%
                for(OrderDisplay o : orders){
                    out.println("<tr>");
                    out.println("<td>" + o.getId_order() + "</td>");
                    out.println("<td>" + o.getAmount1() + "</td>");
                    out.println("<td>" + o.getAmount2() + "</td>");
                    out.println("<td>" + o.getAmount4()+ "</td>");
                    out.println("<td>" + o.getPrice()+ "</td>");
                    out.println("<td>" + o.isSent()+ "</td>");
                    out.println("</tr>");
                }
                %>
            </tbody>
        </table>
    </body>
</html>
