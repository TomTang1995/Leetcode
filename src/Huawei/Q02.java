package Huawei;

import java.util.Scanner;

public class Q02
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        int sales[] = new int[n+1];
        for(int i = 1;i <= n;i++)
            sales[i] = in.nextInt();

        in.nextLine();
        for(int i = 1;i <= m;i++)
        {
            String order = in.nextLine();
            String orders[] = order.split(" ");
            if(orders[0].equals("Q"))
            {
                int sum = 0;
                for(int j = Integer.parseInt(orders[1]);j <= Integer.parseInt(orders[2]);j++)
                    sum = sum + sales[j];

                System.out.println(sum / (Integer.parseInt(orders[2])-Integer.parseInt(orders[1])+1));
            }
            else if(orders[0].equals("U"))
                sales[Integer.parseInt(orders[1])] = sales[Integer.parseInt(orders[1])] + Integer.parseInt(orders[2]);
        }
    }
}
