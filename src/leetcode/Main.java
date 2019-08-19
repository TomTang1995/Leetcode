package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String args[])
    {
        testClass t1 = new testClass();
        testClass t2 = t1;

        System.out.println(t1.hashCode());
        System.out.println(t2.hashCode());
    }
}

class testClass
{
    int test;
}
