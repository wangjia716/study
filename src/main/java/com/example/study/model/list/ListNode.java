package com.example.study.model.list;

import lombok.Data;

@Data
public class ListNode {

    int val;

    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }

}
