package com.unisound.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSplit
{
    public class Solution
    {
        public boolean wordBreak(String s, List<String> wordDict)
        {
            return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
        }

        public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo)
        {
            if (start == s.length()) {
                return true;
            }
            if (memo[start] != null) {
                return memo[start];
            }
            for (int end = start + 1; end <= s.length(); end++) {
                if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                    return memo[start] = true;
                }
            }
            return memo[start] = false;
        }
    }

    public static void main(String[] args)
    {
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("apple");
        wordDict.add("def");
        wordDict.add("apple");
        HashSet aa = new HashSet(wordDict);
        System.out.print(aa);

        Boolean[] bb = new Boolean[5];
        for (int i = 0; i < 5; i++) {
            System.out.print(bb[i]);
        }

    }

}
