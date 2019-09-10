package iqiyi;

import java.util.Scanner;

public class Q02
{
    static double possibility = 0.0;

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int red = in.nextInt();
        int blue = in.nextInt();

        calculatePossibility(1.0, (double)red, (double)blue);
        System.out.println(possibility);
    }

    public static double calculatePossibility(double currentPossibility, double red, double blue)
    {
        // 若无红球，不可能赢
        if(red <= 0)
            return 0.0;

        // 若无蓝球，一定赢
        if(blue <= 0)
            return 1.0;

        // A直接拿红球
        possibility = possibility + currentPossibility*(red/(red+blue));

        if(blue+red>3 && blue>=2)
         {
            // A拿蓝球并且有下一轮
            double p1 = (blue / (red + blue)) * ((blue - 1) / (red + blue - 1)) * (red / (red + blue - 2));
            possibility = possibility + currentPossibility * calculatePossibility((1 - currentPossibility) * p1, red - 1, blue - 2);

            if(blue >= 3)
            {
                double p2 = (blue / (red + blue)) * ((blue - 1) / (red + blue - 1)) * ((blue - 2) / (red + blue - 2));
                possibility = possibility + currentPossibility * calculatePossibility((1 - currentPossibility) * p2, red, blue - 3);
            }
        }

        return 0.0;
    }
}
