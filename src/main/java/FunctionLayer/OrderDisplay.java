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
public class OrderDisplay
{
    int id_order;
    int amount1;
    int amount2;
    int amount4;
    int price;
    boolean sent;

    public OrderDisplay(int id_order, int amount1, int amount2, int amount4, int price, boolean sent)
    {
        this.id_order = id_order;
        this.amount1 = amount1;
        this.amount2 = amount2;
        this.amount4 = amount4;
        this.price = price;
        this.sent = sent;
    }

    public int getId_order()
    {
        return id_order;
    }

    public int getAmount1()
    {
        return amount1;
    }

    public int getAmount2()
    {
        return amount2;
    }

    public int getAmount4()
    {
        return amount4;
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
