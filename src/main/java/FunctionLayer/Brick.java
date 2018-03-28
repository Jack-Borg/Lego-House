package FunctionLayer;

import java.util.*;

public class Brick {
    
    int amount;
    int length;

    public Brick(int amount, int length)
    {
        this.amount = amount;
        this.length = length;
    }

    public int getAmount()
    {
        return amount;
    }

    public int getLength()
    {
        return length;
    }
    
    @Override
    public String toString()
    {
        String brick = "";

        for (int i = 0; i < length; i++)
        {
            brick += ":";
        }

        return amount + " x " + brick + " ";
    }

}
