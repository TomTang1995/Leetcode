package leetcode;

public class Q055
{
    public boolean canJump(int[] nums)
    {
        if(nums==null || nums.length==0)
            return false;

        boolean canJump[] = new boolean[nums.length];
        canJump[0] = true;

        for(int i = 1;i < canJump.length;i++)
        {
            for(int j = i-1;j>=0;j--)
            {
                if(canJump[j] && j+nums[j]>=i)
                {
                    canJump[i] = true;
                    break;
                }
            }
        }

        return canJump[canJump.length-1];
    }
}
