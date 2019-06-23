public class Q547
{
    public int findCircleNum(int[][] M)
    {
        if(M==null || M.length==0 || M[0].length==0)
            return 0;

        int circles = 0;
        boolean isVisited[] = new boolean[M.length];

        for(int i = 0;i < M.length;i++)
        {
            if(!isVisited[i])
            {
                circles++;
                dfs(M, isVisited, i);
            }
        }

        return circles;
    }

    public void dfs(int[][] M, boolean isVisited[], int i)
    {
        isVisited[i] = true;
        for(int k = 0;k < M.length;k++)
        {
            if(M[i][k]==1 && !isVisited[k])
                dfs(M, isVisited, k);
        }
    }
}
