package leetcode;

public class Q050
{
    public static void main(String[] args)
    {
        Q050 q050 = new Q050();
        System.out.println(q050.myPow(2.1, 3));
    }

    public double myPow(double x, int n)
    {
        if(n == 0)
            return 1.0;

        double result = 1.0;
        int temp = Math.abs(n);

        while(temp != 0)
        {
            if((temp&1) == 1)
                result = result * x;

            result = result * result;
            temp = temp >>> 1;
        }

        return n < 0 ? 1.0/result : result;
    }
}
