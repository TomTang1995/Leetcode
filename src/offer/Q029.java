package offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q029
{
    // A solution using PriorityQueue
    // Can also be tackled by all kinds of sort algorithms
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(input==null || input.length<k)
            return list;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int each : input)
            priorityQueue.offer(each);

        for(int i = 0;i < k;i++)
            list.add(priorityQueue.poll());

        return list;
    }

}
