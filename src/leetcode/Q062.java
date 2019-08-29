package leetcode;

public class Q062
{
    public static void main(String[] args)
    {
        Q062 q062 = new Q062();
        System.out.println(q062.uniquePaths(3, 2));
    }

    public int uniquePaths(int m, int n)
    {
        if(m<=0 || n<=0)
            return 0;

        int ways[][] = new int[m][n];
        ways[0][0] = 1;
        for(int j = 1;j < n;j++)
            ways[0][j] = 1;
        for(int i = 1;i < m;i++)
            ways[i][0] = 1;

        for(int i = 1;i < m;i++)
        {
            for(int j = 1;j < n;j++)
                ways[i][j] = ways[i-1][j] + ways[i][j-1];
        }

        return ways[m-1][n-1];
    }

    /*
    int result = 0;

    public int uniquePaths(int m, int n)
    {
        if(m<=0 || n<=0)
            return result;

        boolean isVisited[][] = new boolean[m][n];
        step(0, 0, isVisited, m, n);
        return result;
    }

    public void step(int i, int j, boolean isVisited[][], int m, int n)
    {
        if(i>=m || j>=n)
            return;
        else if(i==m-1 && j==n-1)
        {
            result++;
            return;
        }
        else
        {
            if(isVisited[i][j])
                return;
            else
            {
                isVisited[i][j] = true;
                step(i+1, j, isVisited, m, n);
                step(i, j+1, isVisited, m, n);
                isVisited[i][j] = false;
            }
        }
    }
    */
}
