package com.unisound.tree;

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
/*
 * 如果每个节点都有父指针，那么我们可以从 p 和 q 返回以获取它们的祖先。在这个遍历过程中，我们得到的第一个公共节点是 LCA 节点。我们可以在遍历树时将父指针保存在字典中。
    
    算法：
    
    从根节点开始遍历树。
    在找到 p 和 q 之前，将父指针存储在字典中。
    一旦我们找到了 p 和 q，我们就可以使用父亲字典获得 p 的所有祖先，并添加到一个称为祖先的集合中。
    同样，我们遍历节点 q 的祖先。如果祖先存在于为 p 设置的祖先中，这意味着这是 p 和 q 之间的第一个共同祖先（同时向上遍历），因此这是 LCA 节点

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

    private TreeNode ans;

    public LowestCommonAncestor()
    {
        this.ans = null;
    }

    public TreeNode lowestCommonAncestors(TreeNode root, TreeNode p, TreeNode q)
    {

        searchParent(root, p, q);
        return this.ans;

    }

    public boolean searchParent(TreeNode curNode, TreeNode p, TreeNode q)
    {
        if (curNode == null) {
            return false;
        }

        int left = searchParent(curNode.left, p, q) ? 1 : 0;
        int right = searchParent(curNode.right, p, q) ? 1 : 0;
        int mid = (curNode == p || curNode == q) ? 1 : 0;

        if (mid + left + right >= 2) {
            this.ans = curNode;
        }

        return (mid + left + right > 0);

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
