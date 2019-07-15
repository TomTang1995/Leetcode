package offer;

public class Q006
{
    public static void main(String[] args)
    {
        int array[] = {3,4,4,4,1,2};
        Q006 q006 = new Q006();
        System.out.println(q006.minNumberInRotateArray(array));
    }

    public int minNumberInRotateArray(int [] array)
    {
        if(array==null || array.length==0)
            return -1;
        if(array[0] < array[array.length-1])
            return array[0];

        return minNumberHelper(array);
    }

    //loop solution
    private int minNumberHelper(int array[])
    {
        int start = 0;
        int end = array.length-1;
        int middle;

        if(array[0] < array[array.length-1])
            return array[0];

        while(start <= end)
        {
            middle = (start + end) / 2;
            if(start == middle)
                return array[start+1];

            if(array[start] < array[middle])
                start = middle;
            else if(array[start] == array[middle])
            {
                //line search
                return lineSearch(array, start);
            }
            else
                end = middle;
        }

        return -1;
    }

    private int lineSearch(int array[], int start)
    {
        for(int i = start+1;i < array.length;i++)
        {
            if(array[i] < array[i-1])
                return array[i];
        }

        return -1;
    }


    /* recursive solution
    private int minNumberHelper(int array[], int start, int end)
    {
        int middle = (start + end) / 2;
        if(middle == start)
            return array[end];

        if(array[middle] > array[start])
            return minNumberHelper(array, middle, end);
        else if(array[middle] == array[start])
        {
            for(int i = middle+1;i < array.length;i++)
            {
                if(array[i] < array[i-1])
                    return array[i];
            }
            return -1;
        }
        else
            return minNumberHelper(array, start, middle);
    }
    */


    /*time complexcity : O(n)
    public int minNumberInRotateArray(int [] array)
    {
        if(array==null || array.length==0)
            return -1;

        int currentMin = array[0];
        for(int i = 1;i < array.length;i++)
        {
            if(array[i] < array[i-1])
            {
                currentMin = array[i];
                break;
            }
        }

        return currentMin;
    }
    */
}
