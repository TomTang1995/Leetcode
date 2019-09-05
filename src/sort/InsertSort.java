package sort;

public class InsertSort
{
    public static void insertSort(int nums[])
    {
        for(int i = 1;i < nums.length;i++)
        {
            for(int j = 0;j < i;j++)
            {
                if(nums[i] < nums[j])
                {
                    int temp = nums[i];
                    for(int k = i;k >= j+1;k--)
                        nums[k] = nums[k-1];

                    nums[j] = temp;
                }
            }
        }
    }
}
