package com.unisound.listNode;

//寻找入环点
/*
 * 从链表头结点到入环点的距离，等于从首次相遇点绕环n-1圈再回到 入环点的距离。 这样一来，
 * 只要把其中一个指针放回到头节点位置，另一个指针保持在首次相 遇点，
 * 两个指针都是每次向前走1步。那么，它们最终相遇的节点，就是入环节点
 */
public class DetectCycle
{
    public ListNode getIntersect(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return slow;
            }
        }

        return null;

    }

    public ListNode detectCycle(ListNode head)
    {
        if (head == null) {
            return null;
        }

        ListNode intersectNode = getIntersect(head);
        if (intersectNode == null) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = intersectNode;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;

    }

    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

    }

}
