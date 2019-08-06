package offer;

import java.util.HashSet;
import java.util.Set;

public class Q054
{
    int order = 1;
    int appearTimes[][] = new int[2][256];

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(appearTimes[0][ch] == 0)
        {
            appearTimes[0][ch] = 1;
            appearTimes[1][ch] = order;
            order++;
        }
        else if(appearTimes[0][ch] == 1)
            appearTimes[0][ch] = -1;
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int currentMin = order;
        char result = '#';
        for(int i = 0;i < appearTimes[0].length;i++)
        {
            if(appearTimes[1][i] != 0)
            {
                if(appearTimes[0][i]==1 && appearTimes[1][i]<currentMin)
                {
                    currentMin = appearTimes[1][i];
                    result = (char)i;
                }
            }
        }

        return result;
    }

}
