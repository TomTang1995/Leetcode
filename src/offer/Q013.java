package offer;

public class Q013
{
    public static void main(String[] args)
    {
        int array[] = {1,2,3,4,5,6};
        Q013 q013 = new Q013();
        q013.reOrderArray(array);
        for (int each : array)
            System.out.printf(each + " ");

    }

    public void reOrderArray(int [] array)
    {
        if(array==null || array.length==0)
            return;

        int currentInsert = 0;

        for(int i = 0;i < array.length;i++)
        {
            if(array[i] % 2 == 0)
            {
                int nextOdd = i+1;
                for(;nextOdd < array.length;nextOdd++)
                {
                    if(array[nextOdd] % 2 == 1)
                        break;
                }

                if(nextOdd == array.length)
                    break;
                else
                {
                    int temp = array[nextOdd];
                    for(int j = nextOdd;j > currentInsert;j--)
                        array[j] = array[j-1];

                    array[currentInsert] = temp;
                }
            }

            currentInsert++;
        }

        return;
    }
}
