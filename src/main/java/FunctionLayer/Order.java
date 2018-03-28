/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FunctionLayer;

/**
 *
 * @author GAIMZ
 */
public class Order
{
    int id_order;
    int id_user;
    int length;
    int width;
    int height;
    int price;
    boolean sent;

    public Order(int id_user, int length, int width, int height, int price, boolean sent)
    {
        this.id_user = id_user;
        this.length = length;
        this.width = width;
        this.height = height;
        this.price = price;
        this.sent = sent;
    }

    public int getId_order()
    {
        return id_order;
    }

    public void setId_order(int id_order)
    {
        this.id_order = id_order;
    }

    public int getId_user()
    {
        return id_user;
    }

    public int getLength()
    {
        return length;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int getPrice()
    {
        return price;
    }

    public boolean isSent()
    {
        return sent;
    }
}
