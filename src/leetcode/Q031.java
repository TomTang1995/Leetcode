package leetcode;

public class Q031
{
    public void nextPermutation(int[] nums)
    {
        if(nums==null || nums.length==0)
            return;

        int i, j;
        for(i = nums.length-2;i >= 0;i--)
        {
            if(nums[i] < nums[i+1])
                break;
        }

        if(i >= 0)
        {
            for(j = nums.length-1;j >= i;j--)
            {
                if(nums[j] > nums[i])
                    break;
            }
            swap(nums, i, j);
        }

        i = i + 1;
        j = nums.length-1;
        while (i <= j)
        {
            swap(nums, i ,j);
            i++;
            j--;
        }
    }

    public void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
