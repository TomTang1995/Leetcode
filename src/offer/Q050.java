package offer;

public class Q050
{
    public static void main(String[] args)
    {
        int numbers[] = {2,3,1,0,2,5,3};
        int duplication[] = new int[1];
        Q050 q050 = new Q050();
        q050.duplicate(numbers, 5, duplication);
        System.out.println(duplication[0]);

    }

    public boolean duplicate(int numbers[],int length,int [] duplication)
    {
        boolean hasZeroAppeared = false;
        for(int i = 0;i < length;i++)
        {
            if(numbers[Math.abs(numbers[i])]<0 || (numbers[Math.abs(numbers[i])]==0 && hasZeroAppeared))
            {
                duplication[0] = Math.abs(numbers[i]);
                return true;
            }
            else
            {
                if(numbers[i] == 0)
                    hasZeroAppeared = true;

                numbers[Math.abs(numbers[i])] = -numbers[Math.abs(numbers[i])];
            }
        }
        return false;
    }


    /*
    //An Alternative Solution
    //time complexity: O(n), space complexity: O(n)
    public boolean duplicate(int numbers[],int length,int [] duplication)
    {
        boolean hasAppeared[] = new boolean[length];
        for(int i = 0;i < length;i++)
        {
            if(hasAppeared[numbers[i]])
            {
                duplication[0] = numbers[i];
                return true;
            }
            else
                hasAppeared[numbers[i]] = true;
        }

        return false;
    }
    */
}
