public class Q190
{
    public int reverseBits(int n)
    {
        int temp = 0;
        int pow = 1;
        for(int i = 0;i < 31;i++)
        {
            int currentBit = (n >>> (31-i)) & 1;
            temp = temp + pow*currentBit;
            pow = pow * 2;
        }

        if((n&1) == 1)
            temp = Integer.MIN_VALUE + temp;

        return temp;
    }
}
