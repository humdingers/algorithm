package com.unisound.doublePointer;

import java.util.ArrayList;
import java.util.List;

/*
 * 658. 找到 K 个最接近的元素
    给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。
    
    示例 1:
    
    输入: [1,2,3,4,5], k=4, x=3
    输出: [1,2,3,4]
     
    
    示例 2:
    
    输入: [1,2,3,4,5], k=4, x=-1
    输出: [1,2,3,4]
 */
/*
 * 一个一个删，因为是有序数组，且返回的是连续升序子数组，所以每一次删除的元素一定是位于边界；

2、一共 77 个元素，要保留 33 个元素，因此要删除 44 个元素；

3、因为要删除的元素都位于边界，于是可以使用双指针对撞的方式确定保留区间，即“最优区间”。

 */
public class FindClosestElements
{
    public List<Integer> findClosestElements(int[] arr, int k, int x)
    {
        int len = arr.length;

        int left = 0;
        int right = len - 1;

        int removesize = len - k;

        while (removesize > 0) {
            if (x - arr[left] <= arr[right] - x) {
                right--;
            } else {
                left++;
            }
            removesize--;
        }

        List<Integer> res = new ArrayList<Integer>();

        for (int i = left; i <= right; i++) {
            res.add(arr[i]);
        }

        return res;

    }

}
