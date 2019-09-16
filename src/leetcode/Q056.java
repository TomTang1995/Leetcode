package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q056
{
    static class interval
    {
        int value1;
        int value2;

        interval(int value1, int value2)
        {
            this.value1 = value1;
            this.value2 = value2;
        }
    }

    public int[][] merge(int[][] intervals)
    {
        if(intervals==null || intervals.length==0 || intervals[0].length==0)
            return intervals;

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                if(o1[0] < o2[0])
                    return -1;
                else if(o1[0] > o2[0])
                    return 1;
                else
                {
                    if(o1[1] < o2[1])
                        return -1;
                    else if(o1[1] == o2[1])
                        return 0;
                    else
                        return 1;
                }
            }
        });

        List<interval> list = new ArrayList<>();
        list.add(new interval(intervals[0][0], intervals[0][1]));
        for(int i = 1;i < intervals.length;i++)
        {
            if(list.get(list.size()-1).value2 < intervals[i][0])
                list.add(new interval(intervals[i][0], intervals[i][1]));
            else if(list.get(list.size()-1).value2 >= intervals[i][1])
                continue;
            else
                list.get(list.size()-1).value2 = intervals[i][1];
        }

        int result[][] = new int[list.size()][2];
        for(int i = 0;i < list.size();i++)
        {
            result[i][0] = list.get(i).value1;
            result[i][1] = list.get(i).value2;
        }

        return result;
    }
}