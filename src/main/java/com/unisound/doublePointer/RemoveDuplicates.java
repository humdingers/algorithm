package com.unisound.doublePointer;

//删除排序数组中的重复项
/*
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，
 * 返回移除后数组的新长度。 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。 示例 1: 给定数组 nums =
 * [1,1,2], 函数应该返回新的长度 2, 
 * 并且原数组 nums 的前两个元素被修改为 1, 2。 你不需要考虑数组中超出新长度后面的元素
 */
/*
 * 80. 删除排序数组中的重复项 II
给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

示例 1:

给定 nums = [1,1,1,2,2,3],

函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。

你不需要考虑数组中超出新长度后面的元素
 */

/*
 * 1047. 删除字符串中的所有相邻重复项
给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

在 S 上反复执行重复项删除操作，直到无法继续删除。

在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

 

示例：

输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 */
public class RemoveDuplicates
{

    public int RemoveDuplicates(int[] nums)
    {
        if (nums.length == 0)
            return 0;
        int i = 0;
        /*
         * 方法：双指针法 算法 数组完成排序后，我们可以放置两个指针 ii 和 jj， 其中 ii 是慢指针，而 jj 是快指针。只要 nums[i] = nums[j]nums[i]=nums[j]，我们就增加 jj
         * 以跳过重复项。 当我们遇到 nums[j] ! =nums[i] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]）的值复制到 nums[i + 1]。然后递增 ii，接着我们将再次重复相同的过程，直到
         * jj 到达数组的末尾为止。
         */
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public int removeDuplicates(int[] nums)
    {
        int slow = 1;
        int max = 2;

        for (int fast = 2; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow - max + 1]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;

    }

    public String removeDuplicates(String S)
    {
        StringBuilder sb = new StringBuilder();

        int length = 0;

        for (char c : S.toCharArray()) {
            if (length > 0 && sb.charAt(length - 1) == c) {
                sb.deleteCharAt(length - 1);
                length--;

            } else {
                sb.append(c);
                length++;
            }
        }

        return sb.toString();

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
