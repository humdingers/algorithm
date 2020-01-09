package com.unisound.algorithm;

public class RotateArrayTemp
{
    // 使用额外的数组
    // 算法

    // 我们可以用一个额外的数组来将每个元素放到正确的位置上，
    // 也就是原本数组里下标为 ii 的我们把它放到 (i+k)\%数组长度(i+k)%数组长度 的位置。然后把新的数组拷贝到原数组中

    public void rotateArray(int[] nums, int k)
    {
        int[] tmp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            tmp[(i + k) % nums.length] = nums[i];

        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = tmp[i];
        }

    }

    /*
     * 使用环状替换 算法 如果我们直接把每一个数字放到它最后的位置，但这样的后果是遗失原来的元素。因此，我们需要把被替换的数字保存在变量 temptemp
     * 里面。然后，我们将被替换数字（temptemp）放到它正确的位置，并继续这个过程 nn 次， nn 是数组的长度。这是因为我们需要将数组里所有的元素都移动。但是，这种方法可能会有个问题，如果 n\%k==0n%k==0，其中
     * k=k\%nk=k%n （因为如果 kk 大于 nn ，移动 kk 次实际上相当于移动 k\%nk%n 次）。这种情况下，我们会发现在没有遍历所有数字的情况下回到出发数字。此时，我们应该从下一个数字开始再重复相同的过程。
     */

    public void rotateArrayReplace(int[] nums, int k)
    {
        int count = 0;

        k = k % nums.length;

        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];

            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;

                current = next;

                count++;
            } while (start != current);

        }

    }

}
