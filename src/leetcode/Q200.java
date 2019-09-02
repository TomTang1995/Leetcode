package leetcode;

public class Q200
{
    public int numIslands(char[][] grid)
    {
        if(grid==null || grid.length==0 || grid[0].length==0)
            return 0;

        int count = 0;
        boolean isVisited[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0;i < grid.length;i++)
        {
            for(int j = 0;j < grid[0].length;j++)
            {
                if(!isVisited[i][j] && grid[i][j]=='1')
                {
                    count++;
                    search(grid, isVisited, i, j);
                }
            }
        }

        return count;
    }

    public void search(char[][] grid, boolean[][] isVisited, int i, int j)
    {
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
            return;

        if(isVisited[i][j])
            return;

        if(grid[i][j] == '1')
        {
            isVisited[i][j] = true;
            search(grid, isVisited, i+1, j);
            search(grid, isVisited, i-1, j);
            search(grid, isVisited, i, j+1);
            search(grid, isVisited, i, j-1);
        }
    }
}
