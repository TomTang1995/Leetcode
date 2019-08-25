package leetcode;

public class Q048
{
    public void rotate(int[][] matrix)
    {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return;

        //上下交换（行）
        int circle = (matrix.length - 1) / 2;
        int temp;
        for(int i = 0;i <= circle;i++)
        {
            for(int j = 0;j < matrix[0].length;j++)
            {
                temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length-1-i][j];
                matrix[matrix.length-1-i][j] = temp;
            }
        }

        //对角线翻转
        for(int i = 0;i < matrix.length;i++)
        {
            for(int j = i;j < matrix[0].length;j++)
            {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
