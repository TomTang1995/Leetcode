package offer;

import java.util.ArrayList;

public class Q033
{
    public int GetUglyNumber_Solution(int index)
    {
        if(index <= 0)
            return 0;

        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        ArrayList<Integer> list5 = new ArrayList<>();
        ArrayList<Integer> uglyNumber = new ArrayList<>();
        uglyNumber.add(1);

        int count = 1;
        while (count < index)
        {
            int lastUglyNumber = uglyNumber.get(uglyNumber.size()-1);
            list2.add(2 * lastUglyNumber);
            list3.add(3 * lastUglyNumber);
            list5.add(5 * lastUglyNumber);
            int minNumber = findMinNumber(list2, list3, list5);
            uglyNumber.add(minNumber);
            removeMinNumber(list2, list3, list5, minNumber);
            count++;
        }

        return uglyNumber.get(uglyNumber.size()-1);
    }

    private int findMinNumber(ArrayList<Integer> list2, ArrayList<Integer> list3, ArrayList<Integer> list5)
    {
        if(list2.get(0) < list3.get(0))
            return list2.get(0) < list5.get(0) ? list2.get(0) : list5.get(0);
        else
            return list3.get(0) < list5.get(0) ? list3.get(0) : list5.get(0);
    }

    private void removeMinNumber(ArrayList<Integer> list2, ArrayList<Integer> list3, ArrayList<Integer> list5, int minNumber)
    {
        if(list2.get(0) == minNumber)
            list2.remove(0);
        if(list3.get(0) == minNumber)
            list3.remove(0);
        if(list5.get(0) == minNumber)
            list5.remove(0);
    }
}
