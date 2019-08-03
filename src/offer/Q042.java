package offer;

import java.util.ArrayList;

public class Q042
{
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(array==null || array.length==0)
            return list;

        int currentMin = Integer.MAX_VALUE;
        int left=0, right = array.length-1;
        while(left < right)
        {
            if(array[left] + array[right] == sum)
            {
                if(array[left] * array[right] < currentMin)
                {
                    list.clear();
                    list.add(array[left]);
                    list.add(array[right]);
                    currentMin = array[left] * array[right];
                }
                left++;
                right--;
            }
            else if(array[left] + array[right] < sum)
                left++;
            else
                right--;
        }

        return list;
    }
}
