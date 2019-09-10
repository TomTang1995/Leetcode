package leetcode;

public class Q215
{
    public int findKthLargest(int[] nums, int k)
    {
        quickSort(nums);
        return nums[nums.length-k];
    }

    // quick sort
    public void quickSort(int nums[])
    {
        quickSort(nums, 0, nums.length-1);
    }

    public void quickSort(int nums[], int start, int end)
    {
        if(start >= end)
            return;

        int pivotIndex = findPivotIndex(nums, start, end);
        quickSort(nums, start, pivotIndex-1);
        quickSort(nums, pivotIndex+1, end);
    }

    public int findPivotIndex(int nums[], int start, int end)
    {
        int pivot = nums[start];
        int low = start+1, high = end;
        while (low < high)
        {
            while (low<=high && nums[low]<=pivot)
                low++;

            while (low<=high && nums[high]>pivot)
                high--;

            if(low < high)
            {
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
            }
        }

        if(pivot > nums[high])
        {
            nums[start] = nums[high];
            nums[high] = pivot;
            return high;
        }
        else
            return start;
    }
}
