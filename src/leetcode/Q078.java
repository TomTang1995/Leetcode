package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q078
{
    public static void main(String[] args)
    {
        Q078 q078 = new Q078();
        int nums[] = new int[]{1,2,3};
        List<List<Integer>> result = q078.subsets(nums);
        System.out.println(result);

    }

    public List<List<Integer>> subsets(int[] nums)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> temp = new ArrayList<>();
        result.add(new ArrayList<>());

        for(int i = 0;i < nums.length;i++)
        {
            temp = new ArrayList<>(result);
            result.clear();
            for(List<Integer> each : temp)
            {
                result.add(each);
                List<Integer> newEach = new ArrayList<>(each);
                newEach.add(nums[i]);
                result.add(newEach);
            }
        }

        return result;
    }
}
