package com.example.study.model.list;


import org.springframework.boot.json.JsonParser;

import java.util.List;


public class ListOperation {

    public static ListNode reverse(ListNode head) {
        ListNode reverseNode = new ListNode(0);
        for (ListNode listNode = head;listNode != null;listNode = listNode.next) {
            ListNode newNode = new ListNode(listNode.val);
            if (reverseNode.next != null) {
                newNode.next = reverseNode.next;
            }
            reverseNode.next =newNode;
        }
        return reverseNode.next;
    }

    public static Boolean hasCycle(ListNode head) {
        ListNode oneSizeNode = head;
        if (head == null ||oneSizeNode.next == null) {
            return Boolean.FALSE;
        }
        ListNode twoSizeNode = head.next.next;
        for (;twoSizeNode != null;oneSizeNode = oneSizeNode.next, twoSizeNode = twoSizeNode.next.next) {
            if (oneSizeNode == twoSizeNode) {
                return Boolean.TRUE;
            }
            if (twoSizeNode.next == null || oneSizeNode.next == null) {
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {

        /**
         * 比较最小节点
         */
        ListNode listNode = compareMinNode(lists);

        ListNode head = listNode;

        /**
         * 构造新的list
         */
        addNode(lists, head);
        return head;
    }

    private static void addNode(ListNode[] lists,  ListNode tailNode) {
        if (tailNode == null) {
            return ;
        }
        ListNode[] newList = buildNewList(lists, tailNode);
        /**
         * 比较最小节点
         */
        tailNode.next = compareMinNode(newList);
        if (tailNode.next == null) {
            return ;
        }
        /**
         * 添加节点
         */
        tailNode = tailNode.next;
        addNode(newList, tailNode);
    }

    public static ListNode[] buildNewList(ListNode[] lists, ListNode listNode) {
        ListNode[] newList = new ListNode[lists.length];
        for (int i=0; i<lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            if (lists[i] == listNode) {
                newList[i] = lists[i].next;
            } else {
                newList[i] = lists[i];
            }
        }
        return newList;
    }

    public static ListNode compareMinNode(ListNode[] listNodes) {
        ListNode minNode = null;
        for (ListNode listNode : listNodes) {
            if (listNode == null) {
                continue;
            }
            if (minNode == null) {
                minNode = listNode;
                continue;
            }
            if (listNode.val < minNode.val) {
                minNode = listNode;
            }

        }
        return minNode;
    }


    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode head = null;
        addMinNode(lists, head);
        return head;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head.next;
        if (slow == null) {
            return null;
        }
        ListNode fast = head.next.next;
        if (fast == null) {
           return null;
        }
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newRoot = new ListNode(-1);
        int i = 1;
        ListNode oneTail = newRoot;
        ListNode twoTail = newRoot;
        while (head != null) {
            ListNode newNode = new ListNode(head.val);
            if (i < m) {
                oneTail.next = newNode;
                oneTail = oneTail.next;
            }
            if (i >= m && i <= n) {
                if (i == m) {
                    twoTail = newNode;
                }
                ListNode temp = oneTail.next;
                oneTail.next = newNode;
                newNode.next = temp;
            }
            if (i> n) {
                twoTail.next = newNode;
                twoTail = twoTail.next;
            }

            head = head.next;
            i++;
        }
        return newRoot.next;

    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
          return null;
        }
        ListNode temp = head;
        int size = 1;
        while (temp.next != null)  {
            size++;
            temp = temp.next;
        }
        int rotateSize = k % size;
        ListNode firstNode = head;
        ListNode tailNode = head;
        for (int j = 0;j< rotateSize;j++) {
            tailNode = tailNode.next;
        }
        while (tailNode.next != null) {
            firstNode = firstNode.next;
            tailNode = tailNode.next;
        }
        ListNode newRoot = new ListNode(-1);
        ListNode index = newRoot;
        ListNode tmp = firstNode.next;
        while (tmp != null) {
            index.next = tmp;
            index = index.next;
            tmp = tmp.next;
        }
        while (head != firstNode) {
           index.next = head;
           index = index.next;
           head = head.next;
        }
        index.next = new ListNode(firstNode.val);
        return newRoot.next;

    }

    public static ListNode swapPairs(ListNode head) {
        ListNode first = head;
        if (first == null) {
            return head;
        }
        ListNode oddNode = head.next;
        if (oddNode == null) {
            return head;
        }
        ListNode root = new ListNode(-1);
        ListNode tmpTail = root;
        while (first != null && oddNode != null) {
            tmpTail.next = new ListNode(oddNode.val);
            tmpTail.next.next = new ListNode(first.val);
            tmpTail = tmpTail.next.next;
            first = oddNode.next;
            if (first != null) {
                oddNode = first.next;
            }

        }
        if (first != null) {
            tmpTail.next = new ListNode(first.val);
            return root.next;
        }
        return root.next;

    }



    private static void addMinNode(ListNode[] lists, ListNode tailNode) {
        ListNode minNode = null;
        for (ListNode listNode : lists) {
            if (listNode == null) {
                continue;
            }
            if (minNode == null) {
                minNode = listNode;
                continue;
            }
            if (listNode.val < minNode.val) {
                minNode = listNode;
            }

        }
        if (minNode == null) {
            return;
        }
        ListNode addNode = new ListNode(minNode.val);
        addNode.next = null;
        if (tailNode == null) {
            tailNode = addNode;
        } else {
            tailNode.next = addNode;
        }
        ListNode[] newList = new ListNode[lists.length];
        for (int i=0; i<lists.length; i++) {
            if (lists[i] == minNode) {
                newList[i] = lists[i].next;
            } else {
                newList[i] = lists[i];
            }
        }
        addMinNode(newList, tailNode.next);
    }


    public static ListNode reverseFromM2N(ListNode head, int m, int n) {
//        ListNode resultNode = new ListNode(0);
//        ListNode tail = null;
//        resultNode.next = tail;
//
//        int i = 1;
//        ListNode needReverse = new ListNode(0);
//        ListNode needReverseTail = null;
//        needReverse.next = needReverseTail;
//
//        ListNode nNode = new ListNode(0);
//        ListNode nNodeTail = null;
//        nNode.next = nNodeTail;
//        for (ListNode indexNode = head ; indexNode != null; indexNode = indexNode.next) {
//            if (i < m) {
//                ListNode newNode = new ListNode(indexNode.val);
//                tail = newNode;
//                tail = tail.next;
//                continue;
//            }
//
//            if (i >= m && i <= n) {
//                ListNode listNode = new ListNode(indexNode.val);
//                needReverseTail = listNode;
//                needReverseTail = tail.next;
//                continue;
//            }
//
//            if (i > n) {
//                ListNode newNode = new ListNode(indexNode.val);
//                nNodeTail = newNode;
//                nNodeTail = nNodeTail.next;
//            }
//        }
        return null;
    }

    public static void main(String[] args) {
//        ListNode listNode = new ListNode(5);
//        listNode.next=null;
//        ListNode listNode1 = new ListNode(4);
//        listNode1.next=listNode;
//        ListNode listNode2 = new ListNode(3);
//        listNode2.next=listNode1;
//        System.out.println(listNode2);
//        System.out.println(reverse(listNode2));
//
//        System.out.println(listNode1);
//        System.out.println(reverse(listNode1));
//
//        System.out.println(listNode);
//        System.out.println(reverse(listNode));
//
//        System.out.println(reverse(null));


        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
//        listNode1.next.next.next.next = new ListNode(5);

//        ListNode listNode2 = new ListNode(1);
//        listNode2.next = new ListNode(3);
//        listNode2.next.next = new ListNode(4);
//
//        ListNode listNode3 = new ListNode(2);
//        listNode3.next = new ListNode(6);
//
//        ListNode[] nodes = new ListNode[3];
//        nodes[0] = listNode1;
//        nodes[1] = listNode2;
//        nodes[2] = listNode3;
//        for(ListNode listNode: nodes) {
//            System.out.println(listNode);
//        }
//        ListNode merge = mergeKLists2(nodes);
        System.out.println(swapPairs(listNode1));

//        ListNode[] nodes2 = new ListNode[2];
//        nodes2[0] = listNode1.next;
//        nodes2[1] = listNode2;
//        for(ListNode listNode: nodes2) {
//            System.out.println(listNode);
//        }
    }
}
