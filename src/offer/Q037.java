package offer;

public class Q037
{
    public int GetNumberOfK(int [] array , int k)
    {
        if(array==null || array.length==0)
            return 0;

        int low=0, high=array.length-1;
        int middle = 0;

        while (low <= high)
        {
            middle = (low + high) / 2;
            if(array[middle] == k)
                break;
            else if(array[middle] < k)
                low = middle + 1;
            else
                high = middle - 1;
        }

        if(low > high)
            return 0;

        int count = 0;
        for(int i = middle;i >= 0;i--)
        {
            if(array[i] == k)
                count++;
        }
        for(int j = middle;j < array.length;j++)
        {
            if(array[j] == k)
                count++;
        }

        return count-1;
    }
}
