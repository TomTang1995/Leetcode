package dianxinyun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q01
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>(200);
        while(in.hasNext())
            list.add(in.nextInt());

        int nums[] = new int[list.size()];
        for(int i = 0;i < list.size();i++)
            nums[i] = list.get(i);

        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums)
    {
        if(nums==null || nums.length==0)
            return 0;

        int currentMax[] = new int[nums.length];
        currentMax[0] = nums[0];
        for(int i = 1;i < nums.length;i++)
            currentMax[i] = currentMax[i-1]+nums[i] > nums[i] ? currentMax[i-1]+nums[i] : nums[i];

        Arrays.sort(currentMax);
        return currentMax[currentMax.length-1];
    }
}
