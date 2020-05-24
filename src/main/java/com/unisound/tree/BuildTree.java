package com.unisound.tree;

import java.util.HashMap;
import java.util.Map;

/*
 * 105. 从前序与中序遍历序列构造二叉树
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7
 */

class TreeNode
{
    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int x)
    {
        val = x;
    }
}

public class BuildTree
{
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        int n = preorder.length;
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }

        return build(indexMap, preorder, 0, n - 1, inorder, 0, n - 1);
    }

    public TreeNode build(Map<Integer, Integer> indexMap, int[] preorder, int preorder_left, int preorder_right,
        int[] inorder, int inorder_left, int inorder_right)
    {
        if (preorder_left > preorder_right) {
            return null;
        }
        int preroot = preorder_left;

        int inroot = indexMap.get(preorder[preroot]);

        TreeNode root = new TreeNode(preorder[preroot]);

        int left_tree_size = inroot - inorder_left;

        root.left = build(indexMap, preorder, preroot + 1, preroot + left_tree_size, inorder, inorder_left, inroot - 1);
        root.right =
            build(indexMap, preorder, preroot + left_tree_size + 1, preorder_right, inorder, inroot + 1, inorder_right);

        return root;

    }

}
