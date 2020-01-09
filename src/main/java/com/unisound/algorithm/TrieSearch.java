package com.unisound.algorithm;

class TrieNode
{
    private TrieNode[] links;

    private final int R = 26;

    private boolean isEnd;

    private int size;

    public TrieNode()
    {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch)
    {
        return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch)
    {
        return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node)
    {
        links[ch - 'a'] = node;
        size++;
    }

    public int getLinks()
    {
        return size;
    }

    public void setEnd()
    {
        isEnd = true;
    }

    public boolean isEnd()
    {
        return isEnd;
    }

}

class Trie
{
    private TrieNode root;

    public Trie()
    {
        root = new TrieNode();
    }

    public void insert(String word)
    {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    public TrieNode searchPrefix(String word)
    {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter)) {
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }

    public String searchLongestPrefix(String word)
    {
        TrieNode node = root;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            if (node.containsKey(curLetter) && (node.getLinks() == 1) && (!node.isEnd())) {
                prefix.append(curLetter);
                node = node.get(curLetter);
            } else {
                return prefix.toString();
            }
        }
        return prefix.toString();
    }
}

public class TrieSearch
{

    public static String longestCommonPrefix(String q, String[] strs)
    {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        Trie trie = new Trie();
        for (int i = 1; i < strs.length; i++) {
            trie.insert(strs[i]);
        }

        return trie.searchLongestPrefix(q);
    }

    public static void main(String[] args)
    {
        String[] strs = new String[] {"abadd", "abs", "abd"};
        System.out.print(longestCommonPrefix(strs[0], strs));

    }

}
