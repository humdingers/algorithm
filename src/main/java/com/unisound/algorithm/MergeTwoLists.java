package com.unisound.algorithm;

//合并两个有序链表
public class MergeTwoLists
{

    public ListNode mergeLists(ListNode l1, ListNode l2)
    {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;
        return prehead.next;

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
