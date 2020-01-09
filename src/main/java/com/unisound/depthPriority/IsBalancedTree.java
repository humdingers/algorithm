package com.unisound.depthPriority;

//平衡二叉树
/*
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
    
    本题中，一棵高度平衡二叉树定义为：
    
    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class IsBalancedTree
{
    public boolean isBalanced(TreeNode root)
    {
        // -1 即为存在层数相差大于1
        return depth(root) != -1;

    }

    /**
     * 以当前节点为根节点的树的层数 返回-1的话说明 不满足要求不用求了直接 -1 退出
     * 
     * @param root
     * @return
     */

    public int depth(TreeNode root)
    {
        // 当前节点不存在其层数为0
        if (root == null)
            return 0;

        // 获取左节点的层数
        int left = depth(root.left);

        // 如果层数为-1直接截断
        if (left == -1)
            return -1;

        // 获取右节点的层数
        int right = depth(root.right);

        // 获取右节点的层数
        if (right == -1)
            return -1;

        // 如果左右节点层数相差大于1 直接返回-1 否则返回真实层数
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;

    }

}
