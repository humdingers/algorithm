package com.unisound.greedy;

/*
 * 670. 最大交换
    给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
    
    示例 1 :
    
    输入: 2736
    输出: 7236
    解释: 交换数字2和数字7。
    示例 2 :
    
    输入: 9973
    输出: 9973
    解释: 不需要交换。
 */
public class MaximumSwap
{
    public int maximumSwap(int num)
    {

        // 转成字符数组方便拆分
        char[] arr = Integer.toString(num).toCharArray();

        int[] last = new int[10];
        // 记录1-9最后出现的位置
        for (int i = 0; i < arr.length; i++) {
            last[arr[i] - '0'] = i;
        }

        // 如果后面存在比arr[i]大的数字（从9倒序比较），将其替换
        for (int i = 0; i < arr.length; i++) {
            for (int j = 9; j > arr[i] - '0'; j--) {
                if (last[j] > i) {
                    char temp = arr[last[j]];
                    arr[last[j]] = arr[i];
                    arr[i] = temp;
                    return Integer.valueOf(new String(arr));
                }
            }
        }

        return num;

    }

}
