/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GAIMZ
 */
public class CreateOrder extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException
    {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        int height = Integer.parseInt(request.getParameter("height"));
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));

        LogicFacade.placeOrder(new Order(user.getId(), length, width, height, LogicFacade.calculatePrice(LogicFacade.calculateBricks(height, length, width)), false));

        request.setAttribute("orders", LogicFacade.getOrders(user.getId()));

        return user.getRole() + "orderpage";
    }

}
