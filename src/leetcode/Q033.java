package leetcode;

public class Q033
{
    public int search(int[] nums, int target)
    {
        if(nums==null || nums.length==0)
            return -1;

        int low = 0, high = nums.length-1, middle;
        while(low <= high)
        {
            middle = (low + high) / 2;
            if(target == nums[middle])
                return middle;
            else if(target < nums[middle])
            {
                if(target >= nums[low])
                    high = middle - 1;
                else
                    low = low + 1;
            }
            else    //target > nums[middle]
            {
                if(target <= nums[high])
                    low = middle + 1;
                else
                    high = high - 1;
            }
        }
        return -1;
    }
}
