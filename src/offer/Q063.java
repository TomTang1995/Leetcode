package offer;

import java.util.ArrayList;

public class Q063
{
    ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num)
    {
        if(list.size() == 0)
        {
            list.add(num);
            return;
        }

        int index = 0;
        for(;index < list.size();index++)
        {
            if(num <= list.get(index))
                break;
        }
        if(index == list.size())
            list.add(num);
        else
            list.add(index, num);
    }

    public Double GetMedian()
    {
        if(list.size() == 0)
            return 0.0;

        return list.size()%2==0 ? ((double)list.get(list.size()/2-1) + (double)list.get(list.size()/2)) / 2 : (double)list.get(list.size()/2);
    }

}
