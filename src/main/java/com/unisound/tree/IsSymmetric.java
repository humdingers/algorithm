package com.unisound.tree;

/*
 * 101. 对称二叉树
给定一个二叉树，检查它是否是镜像对称的。

 

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3
 

进阶：
 */
public class IsSymmetric
{
    public boolean isSymmetric(TreeNode root)
    {
        if (root == null) {
            return true;
        }

        return isEqual(root.left, root.right);

    }

    public boolean isEqual(TreeNode left, TreeNode right)
    {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        return (left.val == right.val) && isEqual(left.left, right.right) && isEqual(right.left, left.right);

    }

}
