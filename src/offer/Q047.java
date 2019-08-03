package offer;

public class Q047
{
    public int Sum_Solution(int n)
    {
        int sum = n;

        boolean goOn = (n>0) && ((sum=sum+Sum_Solution(n-1))>0);

        return sum;
    }
}
