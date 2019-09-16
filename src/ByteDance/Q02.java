package ByteDance;

import java.util.Arrays;
import java.util.Scanner;

public class Q02
{
    static class Pair implements Comparable<Pair>
    {
        Integer time;
        Long newFile;

        public Pair(Integer time, Long newFile)
        {
            this.time = time;
            this.newFile = newFile;
        }

        @Override
        public int compareTo(Pair o)
        {
            return this.time - o.time;
        }

    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n; i++)
        {
            int addTime = scanner.nextInt();
            Long newFile = Long.valueOf(scanner.next());
            pairs[i] = new Pair(addTime, newFile);
        }

        Arrays.sort(pairs);
        Long maxRemain = 0L;
        Long[] file = new Long[n+1];
        file[0] = 0l;
        for(int i = 1; i <= n;i++) // i代表第i次，取的file是file[i - 1], time是addtime[i - 1]
        {
            Long remainFile = i==1 ? 0L : file[i-1]-(pairs[i-1].time-pairs[i-2].time);
            file[i] = remainFile>=0 ? remainFile+pairs[i-1].newFile : pairs[i-1].newFile;
            maxRemain = Math.max(maxRemain, file[i]);
        }

        System.out.println((pairs[n-1].time + file[n]) + " " + maxRemain);
    }
}