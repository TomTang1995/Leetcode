package meituan;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Q02
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int total = in.nextInt();

        ReviewEncourage reviewEncourage = new ReviewEncourage(total);
        PrizePool prizePool = new PrizePool();
        Thread t1 = new Thread(new Operation(reviewEncourage, prizePool, 1));
        Thread t2 = new Thread(new Operation(reviewEncourage, prizePool, 2));
        Thread t3 = new Thread(new Operation(reviewEncourage, prizePool, 3));
        t1.start();
        t2.start();
        t3.start();
    }
}

class Operation implements Runnable
{
    public static Lock lock = new ReentrantLock();
    public ReviewEncourage reviewEncourage;
    PrizePool prizePool;
    public int type;

    public Operation()
    {

    }

    public Operation(ReviewEncourage reviewEncourage, PrizePool prizePool, int type)
    {
        this.reviewEncourage = reviewEncourage;
        this.prizePool = prizePool;
        this.type = type;
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                lock.lock();
                if(reviewEncourage.current-4 >= reviewEncourage.total)
                {
                    lock.unlock();
                    break;
                }

                if(reviewEncourage.current % 2 == 0)
                    reviewEncourage.bonus(prizePool);
                else if(reviewEncourage.current % 4 == 1)
                    reviewEncourage.coupon(prizePool);
                else if(reviewEncourage.current % 4 == 3)
                    reviewEncourage.contribution(prizePool);

                reviewEncourage.current++;
                lock.unlock();
            }
            catch(Exception ex)
            {
                ;
            }
        }
    }
}

class ReviewEncourage
{
    public int total;
    public volatile int current = 4;

    // 构造函数,n为中奖用户数
    public ReviewEncourage(int n)
    {
        total = n;
        current = 4;
    }

    // 仅能打印A，表示发放积分
    public void bonus(PrizePool prizePool)
    {
        prizePool.send("A");
    }

    // 仅能打印B，表示发放优惠券
    public void coupon(PrizePool prizePool)
    {
        prizePool.send("B");
    }

    // 仅能打印C，表示发放贡献值
    public void contribution(PrizePool prizePool)
    {
        prizePool.send("C");
    }

}

class PrizePool
{
    public void send(String input)
    {
        System.out.print(input);
    }
}
