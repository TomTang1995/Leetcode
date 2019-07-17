package leetcode;

public class Q026
{
    public int removeDuplicates(int[] nums)
    {
        if(nums==null || nums.length==0)
            return 0;

        int lastNumber = nums[0];
        int insertIndex = 1;
        int searchIndex = 1;
        while(searchIndex < nums.length)
        {
            if(nums[searchIndex] == lastNumber)
            {
                searchIndex++;
                continue;
            }
            else
            {
                nums[insertIndex] = nums[searchIndex];
                lastNumber = nums[searchIndex];
                insertIndex++;
                searchIndex++;
            }
        }

        return insertIndex;
    }
}
