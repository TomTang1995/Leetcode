package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q295
{
    List<Integer> list;

    /** initialize your data structure here. */
    public Q295()
    {
        list = new ArrayList<>();
    }

    public void addNum(int num)
    {
        if(list.size() == 0)
        {
            list.add(num);
            return;
        }

        int i, oldSize = list.size();
        for(i = 0;i < list.size();i++)
        {
            if(num <= list.get(i))
            {
                list.add(i, num);
                break;
            }
        }
        if(i == oldSize)
            list.add(num);
    }

    public double findMedian()
    {
        return (list.size()&1) == 1 ? (double)list.get(list.size()/2) : (list.get((list.size()-1)/2) + list.get(list.size()/2))/2.0;
    }

}
