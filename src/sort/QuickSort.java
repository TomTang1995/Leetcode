package sort;

public class QuickSort
{
    public static void quickSort(int nums[])
    {
        quickSort(nums, 0, nums.length-1);
    }

    public static void quickSort(int nums[], int start, int end)
    {
        if(start >= end)
            return;

        int pivotIndex = partition(nums, start, end);
        quickSort(nums, start, pivotIndex-1);
        quickSort(nums, pivotIndex+1, end);
    }

    public static int partition(int nums[], int start, int end)
    {
        int pivot = nums[start];
        int low=start+1, high=end;

        while(low <= high)
        {
            while(low<=high && nums[low]<=pivot)
                low++;

            while(low<=high && nums[high]>pivot)
                high--;

            // swap
            if(low <= high)
            {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
            }
        }

        if(pivot >= nums[high])
        {
            nums[start] = nums[high];
            nums[high] = pivot;
            return high;
        }
        else
            return start;
    }
}
