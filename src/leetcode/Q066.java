package leetcode;

public class Q066
{
    public int[] plusOne(int[] digits)
    {
        if(digits==null || digits.length==0)
            return digits;

        // 最后一位非9，直接计算然后返回
        if(digits[digits.length-1] != 9)
        {
            digits[digits.length-1]++;
            return digits;
        }

        // 最后一位为9，一定进位
        int index = digits.length-1;
        while(index >= 0)
        {
            digits[index]++;
            if(digits[index] != 10)
                break;
            else
            {
                digits[index] = 0;
                index--;
            }
        }

        if(index >= 0)
            return digits;
        else
        {
            int result[] = new int[digits.length+1];
            result[0] = 1;
            return result;
        }
    }
}
