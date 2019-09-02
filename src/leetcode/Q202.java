package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Q202
{
    public boolean isHappy(int n)
    {
        int sum = n;
        Set<Integer> set = new HashSet<>();
        while(true)
        {
            sum = calculateSum(sum);
            if(sum == 1)
                return true;
            else if(set.contains(sum))
                return false;
            else
                set.add(sum);
        }
    }

    public int calculateSum(int n)
    {
        int result = 0;
        int temp;

        while(n != 0)
        {
            temp = n % 10;
            n = n / 10;
            result = result + temp*temp;
        }
        return result;
    }
}
