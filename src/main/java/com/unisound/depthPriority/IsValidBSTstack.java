package com.unisound.depthPriority;

import java.util.Stack;

class TreeNode
{
    int val;

    TreeNode left;

    TreeNode right;

    TreeNode(int x)
    {
        this.val = x;
    }
}

public class IsValidBSTstack
{
    public boolean isValidBST(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        double inorder = -Double.MAX_VALUE;

        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();

            if (node.val <= inorder)
                return false;

            inorder = node.val;

            node = node.right;

        }

        return true;

    }

}
