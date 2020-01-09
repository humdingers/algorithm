package com.unisound.algorithm;

import java.util.Arrays;
import java.util.LinkedList;

class TreeNodes
{
    int data;

    TreeNodes leftChild;

    TreeNodes rightChild;

    TreeNodes(int data)
    {
        this.data = data;
    }
}

public class binaryTree
{

    public static TreeNodes createBinaryTree(LinkedList<Integer> inputList)
    {
        TreeNodes node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNodes(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;

    }

    public static void preOrderTraveral(TreeNodes node)
    {
        if (node == null) {
            return;
        }
        System.out.print(node.data);
        preOrderTraveral(node.leftChild);
        preOrderTraveral(node.rightChild);
    }

    public static void inOrderTraveral(TreeNodes node)
    {
        if (node == null) {
            return;
        }
        inOrderTraveral(node.leftChild);
        System.out.print(node.data);
        inOrderTraveral(node.rightChild);
    }

    public static void main(String[] args)
    {
        LinkedList<Integer> inputList = new LinkedList<Integer>(
            Arrays.asList(new Integer[] {3, 2, 9, null, null, 10, null, null, 8, 6, null, null, 4}));

        // LinkedList<Integer> inputList = new LinkedList<Integer>(Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 8, 6}));
        //
        TreeNodes treeNode = createBinaryTree(inputList);
        System.out.println(" 前序遍历：");
        preOrderTraveral(treeNode);
        System.out.println();
        System.out.println(" 中序遍历：");
        inOrderTraveral(treeNode);
    }

}
