package com.example.common;

/**
 * 链表节点
 * @author xiejx
 * @date 2024/1/10 19:22
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
