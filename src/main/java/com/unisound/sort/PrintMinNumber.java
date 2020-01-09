package com.unisound.sort;

//把数组排成最小的数
/*
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
     * 打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323    
 */

public class PrintMinNumber
{

    public String printMinNumber(int[] numbers)
    {
        int[] clone = numbers.clone();
        printMin(clone, 0, clone.length - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < clone.length; i++) {
            sb.append(clone[i]);
        }
        return sb.toString();
    }

    // 快速排序

    private static void printMin(int[] array, int start, int end)
    {

        if (start < end) {
            int main_number = array[end];
            int small_cur = start;
            for (int j = start; j < end; j++) {
                // 自定义比较的规则
                // 按照定义的比较规则，将小的数字排在前面
                if (isSmall(String.valueOf(array[j]), String.valueOf(main_number))) {
                    int temp = array[j];
                    array[j] = array[small_cur];
                    array[small_cur] = temp;
                    small_cur++;
                }
            }
            array[end] = array[small_cur];
            array[small_cur] = main_number;
            printMin(array, 0, small_cur - 1);
            printMin(array, small_cur + 1, end);
        }

    }

    public static boolean isSmall(String m, String n)
    {
        String left = m + n;
        String right = n + m;
        boolean result = false;
        // 两个数字两种方式拼接在一起，位数一样，再逐位比较
        // 直接将两个数字进行比较是错误的
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) < right.charAt(i))
                return true;
            else if (left.charAt(i) > right.charAt(i))
                return false;
        }

        return result;
    }

}
