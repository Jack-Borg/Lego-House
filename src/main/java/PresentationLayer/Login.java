package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The purpose of Login is to...
 *
 * @author kasper
 */
public class Login extends Command
{

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = LogicFacade.login(username, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());

        if (user.getRole().equals("employee"))
        {
            request.setAttribute("orders", LogicFacade.getOrders());
        }
        
        request.setAttribute("username", username);

        return user.getRole() + "page";
    }

}
