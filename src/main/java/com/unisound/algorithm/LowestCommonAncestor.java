package com.unisound.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//二叉树的最近公共祖先
/*
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
    
    例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
    
    
    
     
    
    示例 1:
    
    输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    输出: 3
    解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 */
public class LowestCommonAncestor
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        Map<TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>();
        parent.put(root, null);
        stack.push(root);

        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();

            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }

            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        Set<TreeNode> ancesstor = new HashSet<TreeNode>();

        while (p != null) {
            ancesstor.add(p);
            p = parent.get(p);
        }

        while (!ancesstor.contains(q)) {
            q = parent.get(q);
        }
        return q;

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
