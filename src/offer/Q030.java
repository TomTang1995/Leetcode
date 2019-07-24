package offer;

import java.util.Arrays;

public class Q030
{
    //以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变
    public int FindGreatestSumOfSubArray(int[] array)
    {
        if(array==null || array.length==0)
            return 0;

        int currentMax[] = new int[array.length];
        currentMax[0] = array[0];
        for(int i = 1;i < array.length;i++)
            currentMax[i] = Math.max(currentMax[i-1]+array[i], array[i]);

        Arrays.sort(currentMax);
        return currentMax[currentMax.length-1];
    }
}
