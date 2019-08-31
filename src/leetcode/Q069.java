package leetcode;

public class Q069
{
    public int mySqrt(int x)
    {
        if(x <= 0)
            return 0;

        int low = 1, high = x/2, middle;
        while(low <= high)
        {
            middle = (low + high) / 2;
            if(middle > x/middle)
                high = middle-1;
            else if(middle == x/middle)
                return middle;
            else
            {
                if((middle+1) > x/(middle+1))
                    return middle;
                else
                    low = middle+1;
            }
        }

        return low;
    }
}
