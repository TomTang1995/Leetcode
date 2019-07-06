package leetcode;

import java.text.DecimalFormat;
import java.util.*;

public class Q399
{
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, ArrayList<String>> pairs = new HashMap<String, ArrayList<String>>();
        HashMap<String, ArrayList<Double>> valuesPair = new HashMap<String, ArrayList<Double>>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!pairs.containsKey(equation[0])) {
                pairs.put(equation[0], new ArrayList<String>());
                valuesPair.put(equation[0], new ArrayList<Double>());
            }
            if (!pairs.containsKey(equation[1])) {
                pairs.put(equation[1], new ArrayList<String>());
                valuesPair.put(equation[1], new ArrayList<Double>());
            }
            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuesPair.get(equation[0]).add(values[i]);
            valuesPair.get(equation[1]).add(1/values[i]);
        }

        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String[] query = queries[i];
            result[i] = dfs(query[0], query[1], pairs, valuesPair, new HashSet<String>(), 1.0);
            if (result[i] == 0.0) result[i] = -1.0;
        }
        return result;
    }

    private double dfs(String start, String end, HashMap<String, ArrayList<String>> pairs, HashMap<String, ArrayList<Double>> values, HashSet<String> set, double value) {
        if (set.contains(start)) return 0.0;
        if (!pairs.containsKey(start)) return 0.0;
        if (start.equals(end)) return value;
        set.add(start);

        ArrayList<String> strList = pairs.get(start);
        ArrayList<Double> valueList = values.get(start);
        double tmp = 0.0;
        for (int i = 0; i < strList.size(); i++) {
            tmp = dfs(strList.get(i), end, pairs, values, set, value*valueList.get(i));
            if (tmp != 0.0) {
                break;
            }
        }
        set.remove(start);
        return tmp;
    }

    /*
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries)
    {
        double result[] = new double[queries.size()];
        Set<String> set = new HashSet<>();
        for(int i = 0;i < equations.size();i++)
        {
            List<String> each = equations.get(i);
            set.add(each.get(0));
            set.add(each.get(1));
        }

        for(int i = 0;i < queries.size();i++)
        {
            List<String> query = queries.get(i);
            String num1 = query.get(0);
            String num2 = query.get(1);
            if(set.contains(num1) && set.contains(num2))
            {
                if(num1.equals(num2))
                    result[i] = 1.0;
                    //match
                else
                {
                    double temp1 = recursiveSearch(num1, num2, equations, 1.0, values);
                    if(temp1 == 0.0)
                    {
                        double temp2 = recursiveSearch(num2, num1, equations, 1.0, values);
                        if(temp2 == 0.0)
                            result[i] = -1.0;
                        else
                            result[i] = 1.0/temp2;
                    }
                    else
                        result[i] = temp1;
                }
            }
            else
            {
                result[i] = -1.0;
            }
        }

        return result;
    }

    public double recursiveSearch(String num1, String num2, List<List<String>> equations, double current, double[] values)
    {
        for(int i = 0;i < equations.size();i++)
        {
            if(equations.get(i).get(0).equals(num1))
            {
                if(equations.get(i).get(1).equals(num2))
                    return values[i];
                else
                {
                    return values[i] * recursiveSearch(equations.get(i).get(1), num2, equations, current*values[i], values);
                }
            }
            else if(equations.get(i).get(1).equals(num1) && equations.get(i).get(0).equals(num2))
            {
                return 1.0 / values[i];
            }
            else if(equations.get(i).get(0).equals(num2) && )
            else
                continue;
        }

        return 0.0;
    }
    */
}
