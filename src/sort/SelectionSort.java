package sort;

public class SelectionSort
{
    public static void selectionSort(int numbers[])
    {
        for(int i = 0;i < numbers.length;i++)
        {
            int temp = Integer.MAX_VALUE;
            int index = -1;
            for(int j = i;j < numbers.length;j++)
            {
                if(numbers[j] < temp)
                {
                    temp = numbers[j];
                    index = j;
                }
            }
            temp = numbers[i];
            numbers[i] = numbers[index];
            numbers[index] = temp;
        }
    }
}