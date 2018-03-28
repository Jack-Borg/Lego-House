package FunctionLayer;

import java.util.*;

public class WallBuilder
{
    
    public ArrayList<Layer> build(int height, int width, int length)
    {
        ArrayList<Layer> layers = new ArrayList<>();
        for (int layerNumber = 1; layerNumber <= height; layerNumber++)
        {
            layers.add(layerBuilder(layerNumber, width, length));
        }
        return layers;
    }

    private Layer layerBuilder(int layerNumber, int width, int length)
    {
        Layer layer = new Layer(layerNumber);

        if (layerNumber % 2 == 1)
        {
            width -= 4;
        } else if (layerNumber % 2 == 0)
        {
            length -= 4;
        }
        //front
        if (layerNumber <= 6)
        {
            int left = (length-4) / 2;
            int right = (length-4) - left;
            layer.mergeList(sideBuilder(left, layerNumber));
            layer.mergeList(sideBuilder(right, layerNumber));
        } else
        {
            layer.mergeList(sideBuilder(length, layerNumber));
        }
        //back
        layer.mergeList(sideBuilder(length, layerNumber));
        //left
        if (layerNumber >= 2 && layerNumber <= 5)
        {
            int left = (width-4) / 2;
            int right = (width-4) - left;
            layer.mergeList(sideBuilder(left, layerNumber));
            layer.mergeList(sideBuilder(right, layerNumber));
        } else
        {
            layer.mergeList(sideBuilder(width, layerNumber));
        }
        //right
        layer.mergeList(sideBuilder(width, layerNumber));

        return layer;
    }

    private ArrayList<Brick> sideBuilder(int wallSize, int layerNumber)
    {
        int[] brickSizes = new int[]
        {
            4, 2, 1
        };
        ArrayList<Brick> bricks = new ArrayList<>();
        int amount;

        for (int brickSize : brickSizes)
        {
            amount = wallSize / brickSize;
            if (amount > 0)
            {
                wallSize %= brickSize;
                bricks.add(new Brick(amount, brickSize));
            }
            if (wallSize == 0)
            {
                break;
            }
        }
        return bricks;
    }

}
