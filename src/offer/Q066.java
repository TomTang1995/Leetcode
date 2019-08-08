package offer;

public class Q066
{
    int count = 0;
    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold<=0 || rows<=0 || cols<=0)
            return this.count;

        boolean isVisited[][] = new boolean[rows][cols];
        recursiveMovingCount(threshold, rows, cols, 0, 0, isVisited);
        return this.count;
    }

    public void recursiveMovingCount(int threshold, int rows, int cols, int i, int j, boolean[][] isVisited)
    {
        if(i<0 || i>=rows || j<0 || j>=cols)
            return;

        if(isVisited[i][j])
            return;

        isVisited[i][j] = true;
        if(!isMore(i, j, threshold))
        {
            this.count++;
            recursiveMovingCount(threshold, rows, cols, i + 1, j, isVisited);
            recursiveMovingCount(threshold, rows, cols, i - 1, j, isVisited);
            recursiveMovingCount(threshold, rows, cols, i, j + 1, isVisited);
            recursiveMovingCount(threshold, rows, cols, i, j - 1, isVisited);
        }
    }

    public boolean isMore(int i, int j, int threshold)
    {
        int sum = 0;
        while(i!=0 || j!=0)
        {
            sum = sum + i%10;
            i = i/10;

            sum = sum + j%10;
            j = j/10;
        }

        return sum>threshold ? true : false;
    }
}
