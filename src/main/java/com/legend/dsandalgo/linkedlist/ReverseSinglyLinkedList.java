package com.legend.dsandalgo.linkedlist;

/*
* 1. while (cur != null) not while (cur.next != null)
* 2. 画图理解单链表逆序过程
 * */

public class ReverseSinglyLinkedList {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Node head = createLinkedListByArray(arr);
        printLinkedList(head);
        Node phead = reverse(head);
        printLinkedList(phead);
    }

    public static class Node {
        public int value;
        public Node next;
        public Node(int value) {
            this.value = value;
        }
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

    public static Node reverse(Node head) {
        Node pre = null;
        Node next = null;
        Node cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
