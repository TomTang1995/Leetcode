package WeBank;

import java.util.Scanner;

public class Q01
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(findWays(n));
    }

    public static int findWays(int n)
    {
        int pow = 0;
        for(int i = 0;i < 32;i++)
        {
            if(((n>>>i) & 1) == 1)
                pow = Math.max(pow, i);
        }

        pow = pow + 2;
        long result = 1;
        for(int i = 1;i <= pow;i++)
            result = result*i % 1000003;

        return (int)result;
    }
}
