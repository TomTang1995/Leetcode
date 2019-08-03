package offer;

import java.util.HashSet;
import java.util.Set;

public class Q040
{
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[])
    {
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < array.length;i++)
        {
            if(set.contains(array[i]))
                set.remove(array[i]);
            else
                set.add(array[i]);
        }

        Integer temp[] = new Integer[2];
        set.toArray(temp);

        num1[0] = temp[0];
        num2[0] = temp[1];
    }
}
