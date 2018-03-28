/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBAccess;

import FunctionLayer.Brick;
import FunctionLayer.Layer;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Order;
import FunctionLayer.OrderDisplay;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OrderMapper
{

    public static ArrayList<OrderDisplay> getOrders(int user_id) throws LoginSampleException
    {
        ArrayList<OrderDisplay> orders = new ArrayList<>();
        String SQL = "select * from LegoHouse.orders where id_user =?";
        try
        {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                int id_order = rs.getInt("id_order");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                int price = rs.getInt("price");
                boolean sent = rs.getBoolean("sent");
                ArrayList<Layer> layers = LogicFacade.calculateBricks(height, length, width);
                OrderDisplay order = new OrderDisplay(id_order, countBricksSize(layers, 1), countBricksSize(layers, 2), countBricksSize(layers, 4), price, sent);
                orders.add(order);
            }
            return orders;
        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static int placeOrder(Order order) throws LoginSampleException
    {
        String SQL = "insert into LegoHouse.orders (id_user, length, width, height, price) values(?, ?, ?, ?, ?)";

        try
        {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getId_user());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getWidth());
            ps.setInt(4, order.getHeight());
            ps.setInt(5, order.getPrice());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.first();
            int key = rs.getInt(1);

            return key;

        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static int calculatePrice(ArrayList<Layer> layers) throws LoginSampleException
    {
        String SQL = "select * from LegoHouse.bricks";
        int amount1 = countBricksSize(layers, 1);
        int amount2 = countBricksSize(layers, 2);
        int amount4 = countBricksSize(layers, 4);
        try
        {
            Connection con = Connector.connection();
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();
            int price = 0;
            while (rs.next())
            {
                switch (rs.getInt("id_brick"))
                {
                    case (1):
                        price += rs.getInt("price") * amount1;
                        break;
                    case (2):
                        price += rs.getInt("price") * amount2;
                        break;
                    case (3):
                        price += rs.getInt("price") * amount4;
                        break;
                }
            }
            return price;

        } catch (SQLException | ClassNotFoundException ex)
        {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    public static int countBricksSize(ArrayList<Layer> layers, int size)
    {
        int amount = 0;
        for (Layer l : layers)
        {
            for (Brick b : l.getBricks())
            {
                if (b.getLength() == size)
                {
                    amount += b.getAmount();
                }
            }
        }

//        int amount1 = 0;
//        int amount2 = 0;
//        int amount4 = 0;
//        for (Layer l : layers)
//        {
//            for (Brick b : l.getBricks())
//            {
//                switch (b.getLength())
//                {
//                    case (1):
//                        amount1 += b.getAmount();
//                        break;
//                    case (2):
//                        amount2 += b.getAmount();
//                        break;
//                    case (3):
//                        amount4 += b.getAmount();
//                        break;
//                }
//            }
//        }
        return amount;
    }
}
