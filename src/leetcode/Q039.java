package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q039
{
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        if(candidates==null || candidates.length==0)
            return list;

        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, list, temp, 0, 0);

        return list;
    }

    public void combinationSumHelper(int[] candidates, int target, List<List<Integer>> list, List<Integer> temp, int sum, int start)
    {
        if(sum > target)
            return;
        else if(sum == target)
            list.add(new ArrayList<>(temp));
        else
        {
            for(int i = start;i < candidates.length;i++)
            {
                temp.add(candidates[i]);
                combinationSumHelper(candidates, target, list, temp, sum+candidates[i], i);
                temp.remove(temp.size()-1);
            }
        }
    }
}
