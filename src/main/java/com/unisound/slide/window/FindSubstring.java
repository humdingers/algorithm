package com.unisound.slide.window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
    
    注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
    
     
    
    示例 1：
    
    输入：
      s = "barfoothefoobarman",
      words = ["foo","bar"]
    输出：[0,9]
    解释：
    从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
    输出的顺序不重要, [9,0] 也是有效答案

 */

public class FindSubstring
{

    public List<Integer> findSubstring(String s, String[] words)
    {
        int left = 0, right = 0, len = 0;

        // 所有单词数
        int size = words.length;

        List<Integer> res = new ArrayList<Integer>();

        // 如果目标数组为空，则返回一个空集合
        if (words.length == 0) {
            return res;
        } else {
            // 单词长度
            len = words[0].length();
        }

        // 定义两个map集合，一个存目标单词，一个存滑动窗口
        Map<String, Integer> needs = new HashMap<String, Integer>();
        Map<String, Integer> windows = new HashMap<String, Integer>();

        // 初始化目标集合，将单词与出现的次数对应存入map集合中
        for (int i = 0; i < words.length; i++) {
            // 如果单词存在集合中，则返回出现的次数，否则返回0
            int count = needs.getOrDefault(words[i], 0);
            // 存入map中，次数+1
            needs.put(words[i], count + 1);
        }

        // 单词的匹配数量（包括单词和出现次数）
        int match = 0;

        // 由于字符串不一定是单词长度的倍数，所以需要遍历一个单词长度的所有情况
        for (int i = 0; i < len; i++) {
            // 初始化左右指针开始处为i，match初始化为0
            right = left = i;
            match = 0;

            // 右指针最多到字符串的最后一个单词开始位置
            while (right <= s.length() - len) {

                // 向右滑动，存入单词和出现的次数
                String s1 = s.substring(right, right + len);
                // 以单词长度为步长移动右指针
                right += len;
                int count = windows.getOrDefault(s1, 0);
                windows.put(s1, count + 1);

                // 如果单词和出现的次数与目标一致，则匹配+1
                if (needs.containsKey(s1) && windows.get(s1).intValue() == needs.get(s1).intValue()) {
                    match++;
                }

                // 当匹配数等于目标集合的大小（说明已经覆盖了目标集合）
                while (left < right && match == needs.size()) {

                    // right - left / len求出窗口中单词数，如果等于目标单词数，则匹配成功，将左指针位置加入list
                    if ((right - left) / len == size) {
                        res.add(left);
                    }

                    // 左指针右移，类似右指针方法
                    String s2 = s.substring(left, left + len);
                    left += len;
                    windows.put(s2, windows.get(s2) - 1);

                    if (needs.containsKey(s2) && windows.get(s2).intValue() < needs.get(s2).intValue()) {
                        match--;
                    }
                }
            }
            // 清空窗口，进行下一次遍历
            windows.clear();
        }

        return res;
    }

}
