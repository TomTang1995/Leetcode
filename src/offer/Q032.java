package offer;

import java.util.Arrays;
import java.util.Comparator;

public class Q032
{
    public String PrintMinNumber(int [] numbers)
    {
        StringBuilder sb = new StringBuilder();
        if(numbers==null || numbers.length==0)
            return sb.toString();

        Integer numbersArray[] = new Integer[numbers.length];
        for(int i = 0;i < numbers.length;i++)
            numbersArray[i] = numbers[i];

        Arrays.sort(numbersArray, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int o1o2 = Integer.valueOf(String.valueOf(o1) + String.valueOf(o2));
                int o2o1 = Integer.valueOf(String.valueOf(o2) + String.valueOf(o1));

                if(o1o2 > o2o1)
                    return 1;
                else if(o1o2 == o2o1)
                    return 0;
                else
                    return -1;
            }
        });

        for(int i = 0;i < numbersArray.length;i++)
            sb.append(numbersArray[i]);

        return sb.toString();
    }
}
