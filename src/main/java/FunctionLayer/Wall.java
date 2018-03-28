package FunctionLayer;

import java.util.*;

public class Wall {
    
    int size;
    HashMap<Integer, Integer> bricks;

    public Wall(int size)
    {
        this.size = size;
        this.bricks = new HashMap<>();
    }

    public void setBrick(int i, int amount)
    {
        this.bricks.put(i, amount);
    }

    public HashMap<Integer, Integer> getBricks()
    {
        return bricks;
    }
    
    
}
