package com.example.common;

/**
 * 字典树的节点
 * @author xiejx
 * @date 2024/1/10 19:23
 */
public class DictNode {
    char val;
    boolean isEnd;
    DictNode[] children;

    DictNode(char val) {
        this.val = val;
        this.isEnd = false;
        this.children = new DictNode[26];
    }
}
