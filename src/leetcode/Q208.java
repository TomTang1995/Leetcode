package leetcode;

public class Q208
{
    static class TrieNode
    {
        char data;
        boolean isEnd;
        TrieNode children[];

        public TrieNode()
        {
            this.children = new TrieNode[26];
        }
    }

    TrieNode root = null;

    /** Initialize your data structure here. */
    public Q208()
    {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word)
    {
        TrieNode currentNode = root;
        for(int i = 0;i < word.length();i++)
        {
            char currentChar = word.charAt(i);
            if(currentNode.children[currentChar-'a'] != null)
            {
                currentNode = currentNode.children[currentChar-'a'];
                if(i == word.length()-1)
                    currentNode.isEnd = true;
            }
            else
            {
                TrieNode newNode = new TrieNode();
                newNode.data = currentChar;
                newNode.isEnd = i == word.length()-1;
                currentNode.children[currentChar-'a'] = newNode;
                currentNode = newNode;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word)
    {
        TrieNode currentNode = root;
        for(int i = 0;i < word.length();i++)
        {
            char currentChar = word.charAt(i);
            if(currentNode.children[currentChar-'a'] != null)
            {
                if(i == word.length()-1)
                    return currentNode.children[currentChar-'a'].isEnd;
                else
                    currentNode = currentNode.children[currentChar-'a'];
            }
            else
                return false;
        }

        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix)
    {
        TrieNode currentNode = root;
        for(int i = 0;i < prefix.length();i++)
        {
            char currentChar = prefix.charAt(i);
            if(currentNode.children[currentChar-'a'] != null)
                currentNode = currentNode.children[currentChar-'a'];
            else
                return false;
        }

        return true;
    }

}