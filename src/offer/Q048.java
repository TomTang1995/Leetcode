package offer;

public class Q048
{
    public int Add(int num1,int num2)
    {
        int temp = 0;
        while(num2 != 0)
        {
            temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }

        return num1;
    }
}
