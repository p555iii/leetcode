package com.cyd.leecode.module1;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Question2 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(9);
        ListNode listNode4 = new ListNode(1);
        ListNode listNode5 = new ListNode(9);
        ListNode listNode6 = new ListNode(9);
        ListNode listNode7 = new ListNode(9);
        ListNode listNode8 = new ListNode(9);
        ListNode listNode9 = new ListNode(9);
        ListNode listNode10 = new ListNode(9);
        ListNode listNode11 = new ListNode(9);
        ListNode listNode12 = new ListNode(9);
        ListNode listNode13 = new ListNode(9);
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        listNode10.next = listNode11;
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        addTwoNumbers(listNode,listNode4);

    }

    /**
     * 我的解法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<ListNode> listNodes = new ArrayList<>();
        //获取该链表的值
        BigInteger list1RealNum = getListRealNum(l1);
        BigInteger list2RealNum = getListRealNum(l2);
        //相加的结果
        BigInteger resultInt = list1RealNum.add(list2RealNum);
        char[] chars = resultInt.toString().toCharArray();
        for(int i = chars.length-1;i>=0;i--){
            int numericValue = Character.getNumericValue(chars[i]);
            ListNode listNode = new ListNode(numericValue);
            listNodes.add(listNode);

        }
        for(int i = 0;i <listNodes.size()-1;i++){
            ListNode listNode = listNodes.get(i);
            listNode.next = listNodes.get(i+1);
        }
        return listNodes.get(0);
    }
    
    public static BigInteger getListRealNum(ListNode listNode){
        BigInteger flag = BigInteger.valueOf(10);
        ListNode tempListNode = listNode;
        BigInteger returnVal = BigInteger.valueOf(tempListNode.val);
        while ((tempListNode = tempListNode.next) !=null){
            returnVal = returnVal.add(flag.multiply( BigInteger.valueOf(tempListNode.val)));
            flag = flag.multiply(BigInteger.valueOf(10));
        }
        return returnVal;
    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p !=null || q !=null) {
            int x = (p != null ? p.val : 0);
            int y = (q != null ? q.val : 0);
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


    static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
