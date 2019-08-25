package leetcode;

public class Q034
{
    public int[] searchRange(int[] nums, int target)
    {
        if(nums==null || nums.length==0)
            return new int[] {-1, -1};

        int low=0, high=nums.length-1, middle;
        while(low <= high)
        {
            middle = (low + high) / 2;
            if(nums[middle] == target)
            {
                int i;
                int result[] = new int[2];
                for(i = middle-1;i >= 0;i--)
                {
                    if(nums[i] != nums[i+1])
                        break;
                }
                result[0] = i+1;
                for(i = middle+1;i < nums.length;i++)
                {
                    if(nums[i] != nums[i-1])
                        break;
                }
                result[1] = i-1;
                return result;
            }
            else if(nums[middle] > target)
                high = middle - 1;
            else
                low = middle + 1;
        }

        return new int[] {-1, -1};
    }
}
