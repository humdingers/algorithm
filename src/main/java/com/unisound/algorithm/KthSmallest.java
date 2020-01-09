package com.unisound.algorithm;

import java.util.Arrays;
import java.util.LinkedList;

//二叉搜索树中第K小的元素
/*
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

        说明：
        你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
        
        示例 1:
        
        输入: root = [3,1,4,null,2], k = 1
           3
          / \
         1   4
          \
           2
输出: 1

 */
public class KthSmallest
{
    private static int count;

    private static int res;

    public static int kthSmallest(TreeNode root, int k)
    {
        count = k;
        inOrder(root);
        return res;
    }

    private static void inOrder(TreeNode root)
    {
        while (root == null || count < 0)
            return;
        inOrder(root.left);
        if (--count == 0)
            res = root.val;
        inOrder(root.right);

    }

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList)
    {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.left = createBinaryTree(inputList);
            node.right = createBinaryTree(inputList);
        }
        return node;

    }

    public static void main(String[] args)
    {
        LinkedList<Integer> inputList = new LinkedList<Integer>(
            Arrays.asList(new Integer[] {5, 3, 2, null, null, 4, null, null, 8, 7, null, null, 9}));

        // LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 8, 6}));
        //
        TreeNode treeNode = createBinaryTree(inputList);

        System.out.print(kthSmallest(treeNode, 3));

    }

}
