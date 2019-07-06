package offer;

public class Q001
{
    public boolean Find(int target, int [][] array)
    {
        if(array==null || array.length==0 || array[0].length==0)
            return false;

        int i = array.length - 1;
        int j = 0;

        while(i>=0 && j<=array[0].length-1)
        {
            if(array[i][j] == target)
                return true;
            else if(array[i][j] < target)
                j++;
            else
                i--;
        }

        return false;
    }
}
