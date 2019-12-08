package com.example.study.model.queue;


import lombok.Data;

import java.util.List;

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
public class MyCircularDeque {

    private MyNode[] arrays;

    private int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.arrays = new MyNode[k];
        this.size = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == arrays.length) {
            return false;
        }
        MyNode[] newNodeList = new MyNode[arrays.length];
        for (int i = 0; i <= size-1;++i) {
            newNodeList[i+1] = arrays[i];
        }
        MyNode node = new MyNode();
        node.val = value;
        node.pre = null;
        node.next=newNodeList[1];
        newNodeList[0] = node;
        if (size >= 1 && newNodeList[1] != null) {
            newNodeList[1].pre = newNodeList[0];
        }

        this.size++;
        this.arrays = newNodeList;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == arrays.length) {
            return false;
        }
        MyNode node = new MyNode();
        node.val = value;
        if (size == 0) {
            arrays[0] = node;
            size++;
            return true;
        } else {
            node.pre = arrays[size-1];
            if (arrays[size-1] != null) {
                arrays[size-1].next = node;
            }

            arrays[size] = node;
            this.size++;
            return true;
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        if (arrays[0] == null) {
            return false;
        }

        if (size == 1) {
            arrays[0] = null;
            size--;
            return true;
        }

//        MyNode node = arrays[1];
//        arrays[0]= null;
//        node.pre = null;
        MyNode[] newNodeList = new MyNode[arrays.length];
        for (int i = 1; i <= size-1;i++) {
            newNodeList[i-1] = arrays[i];
        }
        this.size--;
        this.arrays = newNodeList;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size < 1) {
            return true;
        }
        if (size == 1) {
            arrays[0] = null;
            return true;
        }
        arrays[size-1]= null;
        MyNode node = arrays[size-2];
        if (node != null) {
            node.next = null;
        }

        this.size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {

        return arrays[0] == null ? -1 : arrays[0].val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (size < 1) {
            return -1;
        }
        if (arrays[size-1] == null) {
           return -1;
        }
        return arrays[size-1].val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == arrays.length;
    }

    private class MyNode {
        private int val;

        private MyNode pre;

        private MyNode next;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public MyNode getPre() {
            return pre;
        }

        public void setPre(MyNode pre) {
            this.pre = pre;
        }

        public MyNode getNext() {
            return next;
        }

        public void setNext(MyNode next) {
            this.next = next;
        }
    }
}
