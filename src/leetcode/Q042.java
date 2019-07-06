package leetcode;

import java.util.PriorityQueue;

public class Q042
{
    public int trap(int[] height)
    {
        if(height==null || height.length<=2)
            return 0;

        int total = 0;
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for(int i = 0;i < height.length;i++)
        {
            if(height[i] > maxValue)
            {
                maxIndex = i;
                maxValue = height[i];
            }
        }

        int leftMax = height[0];
        for(int i = 1;i < maxIndex;i++)
        {
            if(height[i] > leftMax)
                leftMax = height[i];
            else
                total = total + leftMax - height[i];
        }

        int rightMax = height[height.length-1];
        for(int i = height.length-2;i > maxIndex;i--)
        {
            if(height[i] > rightMax)
                rightMax = height[i];
            else
                total = total + rightMax - height[i];
        }

        return total;
    }
}
