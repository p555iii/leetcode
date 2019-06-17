package com.cyd.leecode.module1;

import java.util.Objects;

/**
 * @Description
 * @Author changyandong@e6yun.com
 * @Emoji (゜ - ゜)つ干杯
 * @Created Date: 2019/6/17 18:40
 * @ClassName Question203
 * @Version: 1.0
 */
public class Question203 {

    class LinkedList<E> {

        private Node<E> first;
        private int size;

        public LinkedList() {
            first = new Node<>(null, null);
            this.size = 0;
        }

        public void addLast(E e) {
            add(e, size);
        }

        public void add(E e, int index) {
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("不支持操作");
            }

            Node<E> prev = first;
            //
            for (int i = 0; i < index; i++) {
                prev = prev.next;
            }

            prev.next = new Node<>(e, prev.next);

            size++;
        }

        public E get(int index) {
            if (index < 0 || index > size) {
                throw new IllegalArgumentException("不支持操作");
            }
            Node res = first.next;
            for (int i = 0; i < index; i++) {
                res = res.next;
            }
            if( res == null || res.e ==null){
                return null;
            }
            return (E) res.e;
        }




        public void removeElement(E e){
            Node<E> cur = first.next;
            Node<E> prev = first;

            while (cur != null){
                if(Objects.equals(cur.e,e)){
                    prev.next = cur.next;
                    cur = cur.next;
                    size--;
                }else {
                    prev = prev.next;
                    cur = cur.next;
                }
            }
        }


        public int size() {
            return size;
        }

        class Node<E> {
            public E e;
            public Node<E> next;

            public Node(E e, Node<E> next) {
                this.e = e;
                this.next = next;
            }

            @Override
            public String toString() {
                return e.toString();
            }
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void  test(){
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        removeElements(listNode,1);
    }


    public ListNode removeElements(ListNode head, int val) {
        LinkedList linkedList = new LinkedList();
        while (head != null){
            linkedList.addLast(head.val);
            head = head.next;
        }
        linkedList.removeElement(val);
        if(linkedList.size <= 0){
            return null;
        }
        head = new ListNode((int)linkedList.get(0));
        ListNode first = head;
        int i = 1;
        while (true){
            if(i>=linkedList.size){
                break;
            }
            if(linkedList.get(i) ==null){
                break;
            }

            head.next = new ListNode((int)linkedList.get(i));
            head = head.next;
            i++;
        }

        return first;
    }
}
