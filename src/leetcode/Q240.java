package leetcode;

public class Q240
{
    public boolean searchMatrix(int[][] matrix, int target)
    {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return false;

        int i = matrix.length-1, j = 0;
        while(i>=0 && j<matrix[0].length)
        {
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)
                i--;
            else
                j++;
        }

        return false;
    }
}
