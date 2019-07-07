package offer;

public class Q007
{
    public int Fibonacci(int n)
    {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;

        int result[] = new int[40];
        result[0] = 0;
        result[1] = 1;

        for(int i = 2;i <= n;i++)
            result[i] = result[i-2] + result[i-1];

        return result[n];
    }
}
