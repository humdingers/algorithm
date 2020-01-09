package com.unisound.depthPriority;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal
{
    // 二叉树的中序遍历

    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> res = new ArrayList<Integer>();
        inorderTraversal(root, res);
        return res;

    }

    public void inorderTraversal(TreeNode node, List<Integer> tmp)
    {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, tmp);
        tmp.add(node.val);
        inorderTraversal(node.right, tmp);

    }

}
