package offer;

public class Q012
{
    public double Power(double base, int exponent)
    {
        if(exponent == 0)
            return 1.0;

        int exponentAbs = Math.abs(exponent);
        double result = 1.0;
        while (exponentAbs != 0)
        {
            if((exponentAbs&1) == 1)
                result = result * result * base;
            else
                result = result * result;

            exponentAbs = exponentAbs >>> 1;
        }

        return exponent < 0 ? 1.0/result : result;
    }
}
