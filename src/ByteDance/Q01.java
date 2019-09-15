package ByteDance;

import java.util.Arrays;
import java.util.Scanner;

public class Q01
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        // n个数
        int n = in.nextInt();

        // 数组
        int nums[] = new int[n];
        for(int i = 0;i < nums.length;i++)
            nums[i] = in.nextInt();

        // 和
        int k = in.nextInt();

        System.out.println(threeSum(nums, k));
    }

    public static int threeSum(int nums[], int target)
    {
        Arrays.sort(nums);

        // dup
        int dup[] = new int[nums.length];
        for(int i = 1;i < dup.length;i++)
        {
            if(nums[i] == nums[i-1])
                dup[i] = dup[i-1] + 1;
            else
                dup[i] = dup[i-1];
        }

        int count = 0;
        int i = 0;
        while(i < (nums.length-2))
        {
            int low = i+1, high = nums.length-1;
            while(low < high)
            {
                if(nums[low] + nums[high] < target-nums[i])
                {
                    if(nums[low] == nums[low+1])
                        count = count + (high - low) - (dup[high] - dup[low]) + 1;
                    else
                        count = count + (high - low) - (dup[high] - dup[low]);

                    while(nums[low] == nums[low+1])
                        low++;
                    low++;
                }
                else
                    high--;
            }

            while(nums[i] == nums[i+1])
                i++;
            i++;
        }

        return count;
    }
}
