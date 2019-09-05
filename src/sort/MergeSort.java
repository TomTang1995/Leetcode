package sort;

public class MergeSort
{
    public static void mergeSort(int nums[])
    {
        if(nums.length == 1)
            return;

        int leftLength = nums.length/2;
        int rightLength = nums.length - leftLength;

        int nums1[] = new int[leftLength];
        System.arraycopy(nums, 0, nums1, 0, leftLength);
        mergeSort(nums1);

        int nums2[] = new int[rightLength];
        System.arraycopy(nums, leftLength, nums2, 0, rightLength);
        mergeSort(nums2);

        merge(nums, nums1, nums2);
    }

    public static void merge(int nums[] , int nums1[], int nums2[])
    {
        int index=0, index1=0, index2=0;

        while(index1<nums1.length && index2<nums2.length)
        {
            if(nums1[index1] > nums2[index2])
            {
                nums[index] = nums2[index2];
                index2++;
            }
            else
            {
                nums[index] = nums1[index1];
                index1++;
            }
            index++;
        }

        if(index1 == nums1.length)
            System.arraycopy(nums2, index2, nums, index, nums2.length-index2);
        else
            System.arraycopy(nums1, index1, nums, index, nums1.length-index1);
    }
}
