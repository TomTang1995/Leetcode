package offer;

import java.util.Arrays;

public class Q045
{
    public boolean isContinuous(int [] numbers)
    {
        if(numbers==null || numbers.length==0)
            return false;

        Arrays.sort(numbers);
        int current, count=0;
        for(current = 0;current < numbers.length;current++)
        {
            if(numbers[current] == 0)
                count++;
            else
                break;
        }

        for(current = current + 1;current < numbers.length;current++)
        {
            if(numbers[current] == numbers[current-1])
                return false;
            else
                count = count - (numbers[current] - numbers[current-1] - 1);
        }

        return count >= 0 ? true : false;
    }
}
