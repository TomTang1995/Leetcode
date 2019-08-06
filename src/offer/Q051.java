package offer;

public class Q051
{
    public int[] multiply(int[] A)
    {
        if(A==null || A.length==0)
            return null;

        int temp = 1;
        int B[] = new int[A.length];
        for(int i = 0;i < A.length;i++)
        {
            B[i] = temp;
            temp = temp * A[i];
        }

        temp = 1;
        for(int i = A.length-1;i >= 0;i--)
        {
            B[i] = B[i] * temp;
            temp = temp * A[i];
        }

        return B;
    }
}
