package offer;

public class Q065
{
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix==null || matrix.length==0)
            return false;
        if(str==null || str.length==0)
            return true;

        char charMatrix[][] = new char[rows][cols];
        for(int i = 0;i < rows;i++)
        {
            for(int j = 0;j < cols;j++)
                charMatrix[i][j] = matrix[i*cols + j];
        }

        boolean isVisited[][] = new boolean[rows][cols];
        for(int i = 0;i < rows;i++)
        {
            for(int j = 0;j < cols;j++)
            {
                if(search(charMatrix, rows, cols, i, j, isVisited, 0, str))
                    return true;
            }
        }

        return false;
    }

    public boolean search(char[][] charMatrix, int rows, int cols, int i, int j, boolean[][] isVisited, int index, char[] str)
    {
        if(i<0 || i>=rows || j<0 || j>=cols)
            return false;

        if(isVisited[i][j])
            return false;
        else
        {
            if(index == str.length-1)
            {
                if(charMatrix[i][j] == str[index])
                    return true;
                else
                    return false;
            }
            else
            {
                if(charMatrix[i][j] == str[index])
                {
                    isVisited[i][j] = true;
                    boolean result = search(charMatrix, rows, cols, i+1, j, isVisited, index+1, str)
                            || search(charMatrix, rows, cols, i-1, j, isVisited, index+1, str)
                            || search(charMatrix, rows, cols, i, j+1, isVisited, index+1, str)
                            || search(charMatrix, rows, cols, i, j-1, isVisited, index+1, str);

                    if(result)
                        return true;

                    isVisited[i][j] = false;
                    return false;
                }
                else
                    return false;
            }
        }
    }
}
