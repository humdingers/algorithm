package com.unisound.algorithm;

//反转链表
public class ReverseList
{

    public ListNode reverse(ListNode head)
    {
        ListNode prev = null;
        ListNode curt = head;

        while (curt != null) {
            ListNode tmp = curt.next;
            curt.next = prev;
            prev = curt;
            curt = tmp;
        }

        return prev;

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
