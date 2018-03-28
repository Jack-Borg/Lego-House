package FunctionLayer;

import java.util.*;

public class Layer
{

    int height;
    ArrayList<Brick> bricks;

    public Layer(int height)
    {
        this.height = height;
        this.bricks = new ArrayList<>();
    }

    public void mergeList(ArrayList<Brick> bricks)
    {
        boolean found;
        for (Brick b : bricks)
        {
            found = false;
            for (int i = 0; i < this.bricks.size(); i++)
            {
                if (b.length == this.bricks.get(i).length)
                {
                    found = true;
                    this.bricks.get(i).amount += b.amount;
                }
            }
            if (!found)
            {
                this.bricks.add(b);
            }
        }
    }

    public ArrayList<Brick> getBricks()
    {
        return bricks;
    }

    @Override
    public String toString()
    {
        int amount4 = 0;
        int amount2 = 0;
        int amount1 = 0;
        for (Brick b : bricks)
        {
            switch (b.length)
            {
                case (4):
                    amount4 = b.amount;
                    break;
                case (2):
                    amount2 = b.amount;
                    break;
                case (1):
                    amount1 = b.amount;
                    break;
            }

        }
        return amount4 + " x :::: " + amount2 + " x :: " + amount1 + " x :";
    }
}
