package com.unisound.algorithm.listNode;

//删除排序链表的重复数字
/*
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3

*/
class ListNode
{
    int val;

    ListNode next;

    ListNode(int x)
    {
        this.val = x;
    }
}

public class DeleteDuplicates
{
    public ListNode deleteDuplicates(ListNode head)
    {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
                //
                // ListNode node = current.next;
                // current.next = node.next;
                // node.next = null;//清除野指针
            }

            else {
                current = current.next;
            }

        }

        return head;

    }

}
