package leetcode;

public class Q134
{
    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        int totalGas = 0;
        int totalCost = 0;
        int startIndex = 0;
        int remainedGas = 0;

        for(int i = 0;i < gas.length;i++)
        {
            totalGas = totalGas + gas[i];
            totalCost = totalCost + cost[i];
            remainedGas = remainedGas + gas[i] - cost[i];
            if(remainedGas < 0)
            {
                remainedGas = 0;
                startIndex = i+1;
            }
        }

        return totalGas < totalCost ? -1 : startIndex;
    }

    /*  A More Complex Solution
    public int canCompleteCircuit(int[] gas, int[] cost)
    {
        int startIndex = -1;
        int remainedGas = 0;
        for(int i = 0;i < gas.length;i++)
        {
            if(gas[i] < cost[i])
                continue;
            else
            {
                remainedGas = gas[i];
                int j = i;
                do
                {
                    remainedGas = remainedGas - cost[j];
                    if(remainedGas < 0)
                        break;
                    else
                        remainedGas = remainedGas + gas[(j+1)%gas.length];

                    j = (j+1)%gas.length;
                }
                while (j != i);

                if(j == i)
                {
                    startIndex = i;
                    break;
                }
                else
                    continue;
            }

        }

        return startIndex;
    }
    */
}
