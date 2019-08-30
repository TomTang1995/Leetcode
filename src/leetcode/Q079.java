package leetcode;

public class Q079
{
    public boolean exist(char[][] board, String word)
    {
        if(board==null || board.length==0 || board[0].length==0)
            return false;

        if(word==null || word.length()==0)
            return true;

        boolean isUsed[][] = new boolean[board.length][board[0].length];
        for(int i = 0;i < board.length;i++)
        {
            for(int j = 0;j < board[0].length;j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    boolean result = search(board, word, isUsed, 0, i, j);
                    if(result)
                        return true;
                }
            }
        }

        return false;
    }

    public boolean search(char[][] board, String word, boolean isUsed[][], int index, int i, int j)
    {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return false;

        if(isUsed[i][j])
            return false;

        if(index == word.length()-1)
        {
            if(board[i][j] == word.charAt(index))
                return true;
            else
                return false;
        }

        if(board[i][j] != word.charAt(index))
            return false;

        isUsed[i][j] = true;
        boolean result = search(board, word, isUsed, index+1, i+1, j)
                || search(board, word, isUsed, index+1, i-1, j)
                || search(board, word, isUsed, index+1, i, j+1)
                || search(board, word, isUsed, index+1, i, j-1);

        if(result)
            return true;

        isUsed[i][j] = false;
        return false;
    }
}
