package com.unisound.doublePointer;

//颜色分类
/*
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。

    此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
    
    注意:
    不能使用代码库中的排序函数来解决这道题。
    
    示例:
    
    输入: [2,0,2,1,1,0]
    输出: [0,0,1,1,2,2]

 */
//荷兰国旗问题
//三指针， 其中两个指针，一个寻找0的最右边界，一个寻找2的最左边界
public class SortColors
{
    public void sortColors(int[] nums)
    {
        // 初始化最右边界和最左边界
        int p1 = 0;
        int p2 = nums.length - 1;
        int cur = 0;

        while (cur <= p2) {
            // 把0交换到左边787
            if (nums[cur] == 0) {
                int tmp = nums[cur];
                nums[cur] = nums[p1];
                nums[p1] = tmp;

                // 同时增加0的最右边界值
                p1++;
                // 注意此时要增加cur,由于cur跟p1都是从0出发，p1指向的值cur都比较过
                cur++;
            } else if (nums[cur] == 2) {
                // 把2交换到右边
                int tmp = nums[cur];
                nums[cur] = nums[p2];
                nums[p2] = tmp;
                // 同时减小2的最左边界值
                p2--;
                // 对比上面，此时不增加cur,因为交换到cur的p2值，cur没比较过，需要再比较
            } else {
                cur++;
            }
        }

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
