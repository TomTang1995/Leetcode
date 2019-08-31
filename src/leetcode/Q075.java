package leetcode;

public class Q075
{
    public static void main(String[] args)
    {
        Q075 q075 = new Q075();
        int nums[] = new int[]{2, 0, 1};
        q075.sortColors(nums);
        for(int num : nums)
            System.out.print(num + " ");
    }

    public void sortColors(int[] nums)
    {
        if(nums==null || nums.length==0)
            return;

        int index0 = 0, index2 = nums.length-1, current;
        for(current = 0;current <= index2;current++)
        {
            if(nums[current] == 0)
            {
                nums[current] = nums[index0];
                nums[index0] = 0;
                index0++;
            }
            else if(nums[current] == 1)
                continue;
            else    // == 2
            {
                nums[current] = nums[index2];
                nums[index2] = 2;
                index2--;
                current--;
            }
        }
    }
}
