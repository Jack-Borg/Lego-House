package FunctionLayer;

import DBAccess.OrderMapper;
import DBAccess.UserMapper;
import java.util.ArrayList;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade
{

    public static User login(String username, String password) throws LoginSampleException
    {
        return UserMapper.login(username, password);
    }

    public static User createUser(String username, String password) throws LoginSampleException
    {
        User user = new User(username, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static ArrayList<Layer> calculateBricks(int height, int length, int width)
    {
        WallBuilder builder = new WallBuilder();
        return builder.build(height, width, length);
    }

    public static ArrayList<OrderDisplay> getOrders(int id_user) throws LoginSampleException
    {
        return OrderMapper.getOrders(id_user);
    }

    public static ArrayList<OrderDisplay> getOrders() throws LoginSampleException
    {
        return OrderMapper.getOrders();
    }
    
    public static void updateOrder(int id_order, boolean sent) throws LoginSampleException
    {
        OrderMapper.updateOrder(id_order, sent);
    }

    public static int placeOrder(Order order) throws LoginSampleException
    {
        return OrderMapper.placeOrder(order);
    }

    public static int calculatePrice(ArrayList<Layer> layers) throws LoginSampleException
    {
        return OrderMapper.calculatePrice(layers);
    }

}
