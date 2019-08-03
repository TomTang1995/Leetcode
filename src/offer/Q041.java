package offer;

import java.util.ArrayList;

public class Q041
{
    public static void main(String[] args)
    {
        Q041 q041 = new Q041();
        ArrayList<ArrayList<Integer>> list = q041.FindContinuousSequence(3);
        for(ArrayList<Integer> each : list)
            System.out.println(each);
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum)
    {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if(sum <= 1)
            return list;

        int pLeft = 1, pRight = 1;
        int currentSum = 1;

        while(pRight <= sum)
        {
            //force to transfer
            if(pLeft == pRight)
            {
                pRight++;
                currentSum = currentSum + pRight;
            }

            if(currentSum == sum)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                for(int i = pLeft;i <= pRight;i++)
                    temp.add(i);

                list.add(temp);
                pLeft++;
                currentSum = currentSum - pLeft + 1;
            }
            else if(currentSum < sum)
            {
                pRight++;
                currentSum = currentSum + pRight;
            }
            else
            {
                pLeft++;
                currentSum = currentSum - pLeft + 1;
            }
        }

        return list;
    }
}
