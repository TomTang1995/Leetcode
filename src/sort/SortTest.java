package sort;

public class SortTest
{
    public static void main(String[] args)
    {
        int nums[] = new int[]{5,1,6,9,7,4,2,6,55,-1,-1,6,-20,100,66};
        BubbleSort.bubbleSort(nums);
        for(int each : nums)
            System.out.print(each + " ");

        nums = new int[]{5,1,6,9,7,4,2,6,55,-1,-1,6,-20,100,66};
        SelectionSort.selectionSort(nums);
        System.out.println();
        for(int each : nums)
            System.out.print(each + " ");

        nums = new int[]{5,1,6,9,7,4,2,6,55,-1,-1,6,-20,100,66};
        InsertSort.insertSort(nums);
        System.out.println();
        for(int each : nums)
            System.out.print(each + " ");

        nums = new int[]{5,1,6,9,7,4,2,6,55,-1,-1,6,-20,100,66};
        MergeSort.mergeSort(nums);
        System.out.println();
        for(int each : nums)
            System.out.print(each + " ");

        nums = new int[]{5,1,6,9,7,4,2,6,55,-1,-1,6,-20,100,66};
        QuickSort.quickSort(nums);
        System.out.println();
        for(int each : nums)
            System.out.print(each + " ");
    }
}
