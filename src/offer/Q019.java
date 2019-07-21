package offer;

import java.util.ArrayList;
import java.util.List;

public class Q019
{
    public static void main(String[] args)
    {
        int matrix[][] = {{1,2,3,4,5}};
        Q019 q019 = new Q019();
        ArrayList<Integer> list = q019.printMatrix(matrix);
        for(Integer each : list)
            System.out.print(each + " ");
    }

    public ArrayList<Integer> printMatrix(int [][] matrix)
    {
        ArrayList<Integer> list = new ArrayList<>();

        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return list;

        int circles = Math.min((matrix[0].length-1)/2, (matrix.length-1)/2) + 1;
        int circleCount = 0;
        while(circleCount < circles)
        {
            for(int j = circleCount;j <= matrix[0].length-1-circleCount;j++)
                list.add(matrix[circleCount][j]);

            for(int i = circleCount+1;i <= matrix.length-1-circleCount;i++)
                list.add(matrix[i][matrix[0].length-1-circleCount]);

            for(int j = matrix[0].length-1-circleCount-1;(circleCount!=matrix.length-1-circleCount)&&(j>=circleCount);j--)
                list.add(matrix[matrix.length-1-circleCount][j]);

            for(int i = matrix.length-1-circleCount-1;(matrix[0].length-1-circleCount!=circleCount)&&(i>=circleCount+1);i--)
                list.add(matrix[i][circleCount]);

            circleCount++;
        }

        return list;
    }
}
