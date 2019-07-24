package offer;

import java.util.Arrays;

public class Q028
{
    public int MoreThanHalfNum_Solution(int [] array)
    {
        if(array==null || array.length==0)
            return 0;

        Arrays.sort(array);
        int target = array[array.length/2];
        int count = 0;

        for(int i = array.length/2;i >= 0;i--)
        {
            if(array[i] == target)
                count++;
            else
                break;
        }

        for(int j = array.length/2;j < array.length;j++)
        {
            if(array[j] == target)
                count++;
            else
                break;
        }

        return count-1 > array.length/2 ? target : 0;
    }
}
