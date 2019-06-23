import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String args[])
    {
        List<String> each = new ArrayList<>();
        List<List<String>> equations = new ArrayList<>();
        List<List<String>> queries = new ArrayList<>();
        double values[] = {2.0, 3.0};

        each.add("a");
        each.add("b");
        equations.add(new ArrayList<>(each));
        each.clear();

        each.add("b");
        each.add("c");
        equations.add(new ArrayList<>(each));
        each.clear();

        each.add("a");
        each.add("c");
        queries.add(new ArrayList<>(each));

        Q399 q399 = new Q399();
        //double result[] = q399.calcEquation(equations, values, queries);
        //for(double eachDouble : result)
        //   System.out.println(eachDouble);
    }
}
