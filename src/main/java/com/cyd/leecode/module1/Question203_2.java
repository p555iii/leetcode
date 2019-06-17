package com.cyd.leecode.module1;


import java.util.List;

public class Question203_2 {

    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 没使用 虚拟头结点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {


        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = prev.next.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    /**
     * 使用虚拟头结点
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-2);
        dummyHead.next = head;


        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public ListNode recursionRemove(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode res = recursionRemove(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    public ListNode recursionRemove2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = recursionRemove(head.next, val);
//        if (head.val == val) {
////            return head.next;
////        } else {
////            return head;
////        }
        return head.val == val ? head.next : head;
    }
}
