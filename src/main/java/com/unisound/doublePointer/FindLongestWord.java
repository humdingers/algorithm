package com.unisound.doublePointer;

import java.util.List;

/*
给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。

示例 1:

输入:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

输出: 
"apple"
示例 2:

输入:
s = "abpcplea", d = ["a","b","c"]

输出: 
"a"
*/

public class FindLongestWord
{
    public String findLongestWord(String s, List<String> d)
    {
        char[] sc = s.toCharArray();
        String result = "";

        for (String ds : d) {
            // 先对长度进行判断,(如果小于结果字符串,不用比了 || (如果相等 && 字典顺序小 也不用比了))

            if (result.length() > ds.length() || (result.length() == ds.length() && result.compareTo(ds) < 0)) {
                continue;
            }

            if (isSubStr(sc, ds)) {
                result = ds;
            }
        }
        return result;
    }

    public boolean isSubStr(char[] sc, String ds)
    {
        char[] dsc = ds.toCharArray();
        // 字典字符串下标
        int i = 0;
        // 给定字符串依次与每一个字典里的字符串比较
        // 字符串可以通过删除给定字符串的某些字符来得到",这句话的意思是: 找的这个是给定字符串的子串,相同字符的顺序相等
        // 所以一个指向给定字符串，另一个指针指向字典里的某一个字符串，按顺序依次跟给定字符串比较
        for (char c : sc) {
            if (c == dsc[i]) {
                i++;
            }
            // 如果下标和长度相等,就证明找到了
            if (i == dsc.length) {
                return true;
            }
        }

        return false;

    }

}
