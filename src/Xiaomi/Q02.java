package Xiaomi;

import structures.TreeNode;

import java.util.Stack;

public class Q02
{
    //static Stack<Character> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    // 1(2(3,4(,5)),6(7,))
    static String solution(String input)
    {
        if(input==null || input.length()==0)
            return "";

        TreeNode root = buildTree(input);
        inOrder(root);
        return sb.toString();
    }

    static TreeNode buildTree(String input)
    {
        if(input==null || input.length()==0)
            return null;

        TreeNode root = new TreeNode(Integer.valueOf(input.charAt(0)));
        if(input.length() == 1)
        {
            root.left = null;
            root.right = null;
            return root;
        }

        // 1(2(3,4(,5)),6(7,))
        if(input.charAt(2) == ',') //左子树
            if(input.charAt(2) == '(')  // continue
        {
            int i;
            Stack<Character> stack = new Stack<>();
            for(i = 2;i < input.length();i++)
            {
                if(input.charAt(i) == '(')
                    stack.push(input.charAt(i));
                else if(input.charAt(i) == ')')
                    stack.pop();

                if(stack.isEmpty())
                    break;
            }
            root.left = buildTree(input.substring(2, i+1));
            if(input.charAt(i+1) == ')')
        }
        else
        {
            root.left = null;
            root.right = null;
            return root;
        }




    }



    /*
    static TreeNode buildTree(String input)
    {
        if(input==null || input.length()==0)
            return null;

        TreeNode root;
        if(input.charAt(0) == ',')
            return null;
        else if('0'<=input.charAt(0) && input.charAt(0)<='9')
        {
            root = new TreeNode(Integer.valueOf(input.charAt(0)));
            if(input.length() == 1)
            {
                root.left = null;
                root.right = null;
                return root;
            }
            else
            {
                if(input.charAt(1) == '(')
                {
                    int count = 1;
                    int i;
                    for(i = 2;i < input.length();i++)
                    {
                        if(input.charAt(i) == '(')
                            count++;
                        else if(input.charAt(i) == ')')
                            count--;

                        if(input.charAt(i)==',' && count==1)
                            break;
                    }
                    root.left = buildTree(input.substring(2, i));
                    if(input.charAt(i+1) == ')')
                }
                else
                {
                    root.left = null;
                    root.right = null;
                    return root;
                }
            }
        }
    }
    */
    // 1(2(3,4(,5)),6(7,))
    static void inOrder(TreeNode root)
    {
        if(root == null)
            return;

        inOrder(root.left);
        sb.append(String.valueOf(root.val));
        inOrder(root.right);
    }
}

