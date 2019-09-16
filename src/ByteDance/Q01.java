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

        System.out.println(threeSumSmaller(nums, k));
    }

    public static int threeSumSmaller(int[] nums, int target)
    {
        int count = 0;
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-2;i++)
        {
            int left = i+1, right = nums.length-1;
            while(left < right)
            {
                if(nums[i]+nums[left]+nums[right] < target)
                {
                    count = count + right - left;
                    left++;
                }
                else
                    right--;
            }
        }

        return count;
    }
}