package com.legend.dsandalgo.linkedlist;

/*
* 链表实现partition三个分区问题
*
* 先写主要逻辑，然后再纠结链表合并的问题
* 注意链表合并的代码，的确不容易想清楚
* */

public class SmallerEqualBigger {

    public static void main(String[] args) {
        int[] arr = {84, 2, 23, 14, 95, 6, 67, 38};
        Node head = createLinkedListByArray(arr);
        printLinkedList(head);
        Node phead = go(head, 38);
        printLinkedList(phead);
    }

    public static Node go(Node head, int pivot) {
        if (head == null) return null;
        if (head.next == null) return head;

        Node sH = null;
        Node sT = null;
        Node eH = null;
        Node eT = null;
        Node bH = null;
        Node bT = null;

        Node h1 = head;
        while (h1 != null) {
            Node node = new Node(h1.value);
            if (node.value < pivot) {
                if (sH == null) {
                    sH = node;
                    sT = node;
                } else {
                    sT.next = node;
                    sT = node;
                }
            } else if (node.value == pivot) {
                if (eH == null) {
                    eH = node;
                    eT = node;
                } else {
                    eT.next = node;
                    eT = node;
                }
            } else {
                if (bH == null) {
                    bH = node;
                    bT = node;
                } else {
                    bT.next = node;
                    bT = node;
                }
            }
            h1 = h1.next;
        }

        //合并
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        if (eT != null) {
            eT.next = bH;
        }
        return sT != null ? sT : (eH != null ? eH : bH);
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


}
