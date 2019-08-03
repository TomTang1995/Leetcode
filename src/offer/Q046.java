package offer;

import java.util.ArrayList;
import java.util.List;

public class Q046
{
    public static void main(String[] args)
    {
        Q046 q046 = new Q046();
        System.out.println(q046.LastRemaining_Solution(5, 7));
    }

    public int LastRemaining_Solution(int n, int m)
    {
        if(n<=0 || m<=0)
            return -1;

        List<Integer> children = new ArrayList<>(n);
        for(int i = 0;i < n;i++)
            children.add(i);

        int currentIndex = 0;
        while (children.size() > 1)
        {
            int nextChildIndex = (currentIndex + m -1) % children.size();
            children.remove(nextChildIndex);
            currentIndex = nextChildIndex;
        }

        return children.get(0);
    }
}
