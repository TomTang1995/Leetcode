package leetcode;

import java.util.ArrayList;

public class Q207
{
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        if(prerequisites==null || prerequisites.length==0 || prerequisites[0].length==0)
            return true;

        boolean isVisited[] = new boolean[numCourses];
        ArrayList<Integer>[] list = (ArrayList<Integer>[]) new ArrayList[numCourses];
        for(int[] each : prerequisites)
        {
            if(list[each[0]] == null)
                list[each[0]] = new ArrayList<>();

            list[each[0]].add(each[1]);
        }

        for(int i = 0;i < numCourses;i++)
        {
            if(list[i] != null)
            {
                boolean result = dfs(i, isVisited, list);
                if(!result)
                    return false;
            }
        }

        return true;
    }

    public boolean dfs(int current, boolean[] isVisited, ArrayList<Integer>[] list)
    {
        if(isVisited[current])
            return false;

        if(list[current] != null)
        {
            isVisited[current] = true;
            for(int i = 0;i < list[current].size();i++)
            {
                boolean result = dfs(list[current].get(i), isVisited, list);
                if(!result)
                    return false;
            }
            isVisited[current] = false;
        }

        return true;
    }

    /* diffent implementation, not AC, time exceed limit
    public boolean canFinish(int numCourses, int[][] prerequisites)
    {
        if(prerequisites==null || prerequisites.length==0 || prerequisites[0].length==0)
            return true;

        boolean isVisited[] = new boolean[numCourses];
        boolean courseRequirement[][] = new boolean[numCourses][numCourses];
        for(int i = 0;i < prerequisites.length;i++)
            courseRequirement[prerequisites[i][0]][prerequisites[i][1]] = true;

        for(int i = 0;i < numCourses;i++)
        {
            boolean result = dfs(i, isVisited, courseRequirement);
            if(!result)
                return false;
        }

        return true;
    }

    public boolean dfs(int current, boolean[] isVisited, boolean[][] courseRequirement)
    {
        if(isVisited[current])
            return false;

        for(int i = 0;i < courseRequirement.length;i++)
        {
            if(courseRequirement[current][i])
            {
                isVisited[current] = true;
                boolean result = dfs(i, isVisited, courseRequirement);
                if(!result)
                    return false;
                isVisited[current] = false;
            }
        }

        return true;
    }
    */
}
