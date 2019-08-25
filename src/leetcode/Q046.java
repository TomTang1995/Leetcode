package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q046
{
    public List<List<Integer>> permute(int[] nums)
    {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(nums==null || nums.length==0)
            return list;

        boolean isUsed[] = new boolean[nums.length];
        recursivePermutation(nums, isUsed, list, temp);
        return list;
    }

    public void recursivePermutation(int nums[], boolean isUsed[], List<List<Integer>> list, List<Integer> temp)
    {
        if(temp.size() == nums.length)
        {
            list.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0;i < nums.length;i++)
        {
            if(!isUsed[i])
            {
                isUsed[i] = true;
                temp.add(nums[i]);
                recursivePermutation(nums, isUsed, list, temp);
                temp.remove(temp.size()-1);
                isUsed[i] = false;
            }
        }
    }
}
