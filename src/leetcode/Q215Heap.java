package leetcode;

public class Q215Heap
{
    int heap[];
    int size;

    public static void main(String[] args)
    {
        Q215Heap q215Heap = new Q215Heap();
        int nums[] = new int[]{3,2,1,5,6,4};
        System.out.println(q215Heap.findKthLargest(nums, 2));
    }

    public int findKthLargest(int[] nums, int k)
    {
        heap = new int[nums.length];
        size = 0;
        for(int each : nums)
            add(each);

        for(int each : heap)
            System.out.print(each + " ");

        while(k > 1)
        {
            remove();
            k--;
        }

        return remove();
    }

    public void add(int number)
    {
        heap[size] = number;
        size++;

        int currentIndex = size-1;
        while(currentIndex > 0)
        {
            int parentIndex = (currentIndex-1)/2;
            if(heap[currentIndex] > heap[parentIndex])
            {
                int temp = heap[currentIndex];
                heap[currentIndex] = heap[parentIndex];
                heap[parentIndex] = temp;
                currentIndex = parentIndex;
            }
            else
                break;
        }
    }

    public int remove()
    {
        int result = heap[0];
        size--;

        heap[0] = heap[size];
        int currentIndex = 0;
        while(currentIndex <= size)
        {
            int maxIndex = -1;
            if(currentIndex*2+1<=size && heap[currentIndex]<heap[currentIndex*2+1])
                maxIndex = currentIndex*2+1;
            if(currentIndex*2+2<=size && heap[currentIndex]<heap[currentIndex*2+2])
                maxIndex = heap[currentIndex*2+1] > heap[currentIndex*2+2] ? currentIndex*2+1 : currentIndex*2+2;

            if(maxIndex != -1)
            {
                int temp = heap[currentIndex];
                heap[currentIndex] = heap[maxIndex];
                heap[maxIndex] = temp;
                currentIndex = maxIndex;
            }
            else
                break;
        }

        return result;
    }
}
