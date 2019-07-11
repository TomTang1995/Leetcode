package leetcode;

public class Q007
{
    public static void main(String[] args)
    {
        Q007 q007 = new Q007();
        System.out.println(q007.reverse(-123));
    }

    public int reverse(int x)
    {
        long newNumber = 0L;
        int pow = 1;

        while(x != 0)
        {
            newNumber = newNumber*10 + x%10;
            x = x / 10;
            pow = pow * 10;
        }

        if(newNumber<Integer.MIN_VALUE || newNumber>Integer.MAX_VALUE)
            return 0;
        else
            return (int)newNumber;
    }
}
