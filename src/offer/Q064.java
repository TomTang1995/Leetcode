package offer;

import java.util.ArrayList;

public class Q064
{
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(num==null || size==0 || num.length<size)
            return result;

        int preLoc = -1;
        int preMax = Integer.MIN_VALUE;
        for(int i = 0;i < size;i++)
        {
            if(num[i] >= preMax)
            {
                preMax = num[i];
                preLoc = i;
            }
        }
        result.add(preMax);

        for(int i = size;i < num.length;i++)
        {
            if(num[i] >= preMax)
            {
                result.add(num[i]);
                preMax = num[i];
                preLoc = i;
            }
            else
            {
                //re-search
                if(preLoc == i-size)
                {
                    int tempMax = Integer.MIN_VALUE;
                    int tempLoc = -1;
                    for(int j = i-size+1;j <= i;j++)
                    {
                        if(num[j] >= tempMax)
                        {
                            tempMax = num[j];
                            tempLoc = j;
                        }
                    }
                    result.add(tempMax);
                    preMax = tempMax;
                    preLoc = tempLoc;
                }
                else
                    result.add(preMax);
            }
        }

        return result;
    }
}
