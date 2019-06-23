import java.util.Stack;

public class Q402
{
    public String removeKdigits(String num, int k)
    {
        boolean exist[] = new boolean[num.length()];
        for(int i = 0;i < exist.length;i++)
            exist[i] = true;

        for(int i = 0;i < k;i++)
        {
            //seach for the first number
            int prev, next;
            for(prev = 0;prev < exist.length;prev++)
            {
                if(exist[prev])
                    break;
            }

            //seach for the next number
            for(next = prev+1;next < exist.length;next++)
            {
                if(exist[next])
                    break;
            }

            while(next<exist.length && num.charAt(prev)<=num.charAt(next))
            {
                for(prev = next;prev < exist.length;prev++)
                {
                    if(exist[prev])
                        break;
                }

                for(next = prev+1;next < exist.length;next++)
                {
                    if(exist[next])
                        break;
                }
            }

            exist[prev] = false;
        }

        int index;
        for(index = 0;index < exist.length;index++)
        {
            if(exist[index] && num.charAt(index)!='0')
                break;
        }
        StringBuilder sb = new StringBuilder();
        for(;index < exist.length;index++)
        {
            if(exist[index])
                sb.append(num.charAt(index));
        }

        return sb.toString().equals("") ? "0" : sb.toString();
    }

    /* A More Complex Solution using Stack
    public String removeKdigits(String num, int k)
    {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for(int i = num.length()-1;i >= 0;i--)
            stack2.push(num.charAt(i));

        for(int i = 0;i < k;i++)
        {
            stack1.push(stack2.pop());
            while(!stack2.isEmpty() && stack1.peek()<=stack2.peek())
                stack1.push(stack2.pop());

            if(stack1.peek() > stack2.peek())
                stack1.pop();
            else
                stack1.pop();

            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        }

        StringBuilder sb = new StringBuilder();
        while(!stack2.isEmpty())
        {
            if(stack2.peek() == '0')
                stack2.pop();
            else
                break;
        }

        while(!stack2.isEmpty())
            sb.append(stack2.pop());

        return sb.toString().equals("") ? "0" : sb.toString();
    }
    */
}
