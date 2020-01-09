package com.unisound.listNode;

//两数相加
/*
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

        如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
        
        您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
        
        示例：
        
        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807

 */

public class AddTwoNumber
{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }

    // 打印链表
    public static void print(ListNode node)
    {
        if (node == null) {
            return;
        }

        ListNode current = node;
        while (current != null) {
            System.out.print(current.val + "--->");
            current = current.next;
        }
    }

    public static void main(String[] args)
    {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);
        ListNode head2 = new ListNode(5);
        ListNode temp3 = head2;
        temp3.next = new ListNode(6);
        ListNode temp4 = temp3.next;
        temp4.next = new ListNode(4);
        print(addTwoNumbers(head1, head2));

    }

}
