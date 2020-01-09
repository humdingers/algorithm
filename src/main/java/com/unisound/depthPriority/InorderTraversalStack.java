package com.unisound.depthPriority;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//二叉树的中序遍历
public class InorderTraversalStack
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> satck = new Stack<TreeNode>();
        TreeNode curNode = root;

        while (curNode != null || !satck.isEmpty()) {
            while (curNode != null) {
                satck.push(curNode);
                curNode = curNode.left;
            }

            curNode = satck.pop();

            res.add(curNode.val);

            curNode = curNode.right;

        }

        return res;

    }
}
