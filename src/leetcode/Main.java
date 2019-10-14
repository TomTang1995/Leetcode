package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String args[])
    {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1,2});
        list.add(new int[]{3,4});

        int twoDimension[][] = new int[list.size()][list.get(0).length];
        list.toArray(twoDimension);

        for(int i = 0;i < twoDimension.length;i++)
        {
            for(int j = 0;j < twoDimension[0].length;j++)
                System.out.print(twoDimension[i][j] + " ");

            System.out.println();
        }
    }
}