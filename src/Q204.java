public class Q204
{
    public int countPrimes(int n)
    {
        if(n <= 2)
            return 0;

        int result = 0;
        boolean isPrime[] = new boolean[n];
        for(int i = 2;i < n;i++)
        {
            if(!isPrime[i])
            {
                result++;
                for(int j = i+i;j < n;j = j + i)
                    isPrime[j] = true;
            }
        }

        return result;
    }
}
