package leetcode;

public class Q088
{
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        if(n == 0)
            return;

        int currentIndex = m+n-1;
        m--;
        n--;
        while(m>=0 && n>=0)
        {
            if(nums1[m] >= nums2[n])
            {
                nums1[currentIndex] = nums1[m];
                currentIndex--;
                m--;
            }
            else
            {
                nums1[currentIndex] = nums2[n];
                currentIndex--;
                n--;
            }
        }

        if(m < 0)
        {
            for(int i = 0;i <= n;i++)
                nums1[i] = nums2[i];
        }
    }
}
