package com.legend.dsandalgo.linkedlist;

/*
* 判断链表是否为回文链表
* 方法一：直接借用栈
* 方法二：把有半部分链表逆序，得到两个链表同步比对，对比完之后再恢复链表
* */

import java.util.Stack;

public class IsPalindromeLinkedList {

    public static void main(String[] args) {
        int[] arr = {1,2, 3, 4, 3, 2, 1};
        Node head = createLinkedListByArray(arr);
        System.out.println(verify1(head));;
        printLinkedList(head);
    }

    public static Node createLinkedListByArray(int[] arr) {
        if (arr == null || arr.length < 1) return null;
        Node head = new Node(arr[0]);
        Node cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new Node(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    public static void printLinkedList(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static class Node {
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    public static boolean verify1(Node head) {
        Stack<Node>  stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            if (cur.value != stack.pop().value) return false;
            cur = cur.next;
        }
        return true;
    }

    //将链表后半部分逆序，然后顺序遍历两个链表并做比对
    //1 -> 2 -> 3 -> 3 -> 2 -> 1
    //1 -> 2 -> 3 <- 3 <- 2 <- 1
    public static boolean verify2(Node head) {
        if (head == null || head.next == null) return true;
        //找中点
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //逆序
        Node head2 = mid.next;
        mid.next =null;
        Node pre = null;
        Node next = null;
        Node cur = head2;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        Node rHead = pre;

        //遍历对比，判断是否回文
        Node rHeadBak = rHead;
        Node head1 = head;
        printLinkedList(head1);
        printLinkedList(rHead);
        while (head1 != null && rHead != null) {
            if (head1.value != rHead.value) return false;
            head1 = head1.next;
            rHead = rHead.next;
        }

        //恢复原链表
        pre = null;
        next = null;
        cur = rHeadBak;//保存逆序链表头节点，便于恢复
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        mid.next = pre;

        return true;
    }

}
