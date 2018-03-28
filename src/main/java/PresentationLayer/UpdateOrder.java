/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PresentationLayer;

import FunctionLayer.LoginSampleException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FunctionLayer.LogicFacade;
import FunctionLayer.OrderDisplay;
import FunctionLayer.User;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GAIMZ
 */
public class UpdateOrder extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException
    {
        ArrayList<OrderDisplay> orders = LogicFacade.getOrders();

        for (OrderDisplay o : orders)
        {
            boolean sent = request.getParameter(Integer.toString(o.getId_order())).equals("true");
            if (sent != o.isSent())
            {
                LogicFacade.updateOrder(o.getId_order(), !o.isSent());
            }
        }

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String username = user.getUsername();
        request.setAttribute("orders", LogicFacade.getOrders());
        request.setAttribute("username", username);
        
        return "employeepage";
    }
}
