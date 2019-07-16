package leetcode;

public class Q027
{
    public int removeElement(int[] nums, int val)
    {
        if(nums==null || nums.length==0)
            return 0;

        int currentInsertIndex = 0;
        int currentJudgeIndex = 0;

        while(currentJudgeIndex < nums.length)
        {
            if(nums[currentJudgeIndex] != val)
            {
                nums[currentInsertIndex] = nums[currentJudgeIndex];
                currentInsertIndex++;
            }
            currentJudgeIndex++;
        }

        return currentInsertIndex;
    }
}
