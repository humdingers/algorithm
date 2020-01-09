package com.unisound.broardPriority;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

public class LevelOrderTraversal
{

    public static void levelOrderTraversal(TreeNode root)
    {
        // LinkedList继承Deque,queue等接口
        // Deque<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val);

            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }

        }

    }

    public static void preOrderTraveralWithStack(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                System.out.println(treeNode.val);
                stack.push(treeNode);
                treeNode = root.left;

            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;

            }
        }

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
