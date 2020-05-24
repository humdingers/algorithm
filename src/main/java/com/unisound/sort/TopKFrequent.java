package com.unisound.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 692. 前K个高频单词
    给一非空的单词列表，返回前 k 个出现次数最多的单词。
    
    返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
    
    示例 1：
    
    输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
    输出: ["i", "love"]
    解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
        注意，按字母顺序 "i" 在 "love" 之前。
     
    
    示例 2：
    
    输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
    输出: ["the", "is", "sunny", "day"]
    解析: "the", "is", "sunny" 和 "day" 
 */
public class TopKFrequent
{
    public List<String> topKFrequent(String[] words, int k)
    {
        Map<String, Integer> count = new HashMap<String, Integer>();

        for (String item : words) {
            count.put(item, count.getOrDefault(item, 1) + 1);
        }

        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates,
            // 降序排序
            (w1, w2) -> count.get(w1).equals(count.get(w2)) ? w1.compareTo(w2) : count.get(w2) - count.get(w1));

        return candidates.subList(0, k);

    }

}
