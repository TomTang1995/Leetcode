package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q022
{
    public static void main(String[] args)
    {
        Q022 q022 = new Q022();
        List<String> list = q022.generateParenthesis(3);
        for(String each : list)
            System.out.println(each);
    }

    public List<String> generateParenthesis(int n)
    {
        List<String> list = new ArrayList<>();
        String temp = "(";


        generateParenthesisHelper(n, 1, n, temp, list);
        return list;
    }

    public void generateParenthesisHelper(int n, int alreadyNumber, int remainedNumber, String temp, List<String> list)
    {
        if(alreadyNumber == n)
        {
            if(remainedNumber == 0)
                list.add(temp);
            else
                generateParenthesisHelper(n, alreadyNumber, remainedNumber-1, new String(temp+")"), list);
        }
        else
        {
            generateParenthesisHelper(n, alreadyNumber+1, remainedNumber, new String(temp+"("), list);
            //剩下的'）'个数大于0 并且 已经有的'（'的个数需要大于'）'的个数，否则不匹配
            if(remainedNumber>0 && (alreadyNumber+remainedNumber)>n)
                generateParenthesisHelper(n, alreadyNumber, remainedNumber-1, new String(temp+")"), list);
        }
    }
}
