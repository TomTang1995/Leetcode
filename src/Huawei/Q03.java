package Huawei;

import java.util.Scanner;

public class Q03
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T > 0)
        {
            T--;

            int days = in.nextInt();
            int currentMax = 0, currentExp = 0;
            int train[][] = new int[2][100001];

            int first = in.nextInt();
            train[0][first] = 1;
            for(int i = first+1;i < 100001;i++)
                train[1][i] = 1;

            for(int i = 1;i < days;i++)
            {
                int error = in.nextInt();
                if(error == 100000)
                    currentExp = currentExp + train[1][error];
                else
                    currentExp = currentExp + train[1][error] - (i - train[1][error+1]);

                currentMax = Math.max(currentExp, currentMax);

                train[0][error]++;
                for(int j = error+1;j < 100001;j++)
                    train[1][j]++;
            }

            System.out.println(currentMax + " " + currentExp);
        }
    }
}

/*
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T > 0)
        {
            T--;

            int days = in.nextInt();
            int currentMax = 0, currentExp = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(in.nextInt(), 1);
            for(int i = 1;i < days;i++)
            {
                int error = in.nextInt();
                for(Map.Entry<Integer, Integer> entry : map.entrySet())
                {
                    if(entry.getKey() > error)
                        currentExp = currentExp - entry.getValue();
                    else if(entry.getKey() < error)
                        currentExp = currentExp + entry.getValue();
                }
                currentMax = Math.max(currentMax, currentExp);

                if(map.containsKey(error))
                    map.put(error, map.get(error)+1);
                else
                    map.put(error, 1);
            }

            System.out.println(currentMax + " " + currentExp);
        }
    }
    */
