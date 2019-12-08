package com.example.study.trieTree;

import com.example.study.model.tree.TreeNode;
import org.springframework.util.StringUtils;

import java.util.*;

public class TrieTreeOperation {
    static class TrieNode {
        public char data;
        public TrieNode[] childChar;

        TrieNode(char a) {
            data = a;
            childChar = new TrieNode[27];
        }
    }

    static class WordDictionary {

        private TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode('/');
        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            TrieNode p = root;
            char[] wordArray = word.toCharArray();
            for (int i=0;i< wordArray.length;i++) {
                if (wordArray[i] == '.') {
                    if (p.childChar[26] == null) {
                        TrieNode trieNode = new TrieNode('.');
                        p.childChar[26] = trieNode;
                    }
                    p = p.childChar[26];
                } else {
                    int index = wordArray[i] - 'a';
                    if (p.childChar[index] == null) {
                        TrieNode trieNode = new TrieNode(wordArray[i]);
                        p.childChar[index] = trieNode;
                    }
                    p = p.childChar[index];
                }
            }
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            TrieNode p = root;
            return search(word, root);
        }

        private boolean search(String word, TrieNode p) {
            if (p == null) {
                return false;
            }
            char[] wordArray = word.toCharArray();
            for (int i=0;i< wordArray.length;i++) {
                if (wordArray[i] == '.') {
                    if (i == wordArray.length -1) {
                      return true;
                    }
                    TrieNode[] childChar = p.childChar;
                    String newWord = word.substring(i+1);
                    for (int j = 0; j < childChar.length; j++) {
                         if(search(newWord, childChar[j])){
                             return true;
                        }
                    }
                    return search(newWord, p);
                } else {
                    int index = wordArray[i] - 'a';
                    if (p.childChar[index] == null) {
                        return false;
                    }
                    p = p.childChar[index];
                }
            }
            return true;
        }
    }

    public static char findTheDifference(String s, String t) {
        int sSum = 0;
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {
            sSum += chars[i] - 'a';
        }
        int tSum = 0;
        char[] chars1 = t.toCharArray();
        for (int j = 0; j< chars1.length; j++) {
            tSum += chars1[j] - 'a';
        }
        return (char)('a' +(tSum-sSum));

    }

    public static boolean wordPattern(String pattern, String str) {
        char[] patterArray = pattern.toCharArray();
        String[] strArray = str.split(" ");
        if (strArray.length != patterArray.length) {
            return false;
        }

        String[] mapping = new String[26];
        Map<String, Integer> reverseMap = new HashMap<>();
        for (int i = 0; i < patterArray.length; i++) {
            int key = patterArray[i] - 'a';
            if (mapping[key] != null && reverseMap.containsKey(strArray[i])) {
                if (!mapping[key].equals(strArray[i]) || !reverseMap.get(strArray[i]).equals(key)) {
                    return false;
                }
                continue;
            }
            if (mapping[key] == null && !reverseMap.containsKey(strArray[i])) {
                mapping[key] = strArray[i];
                reverseMap.put(strArray[i], key);
                continue;
            }
            return false;
        }
        return true;
    }

    public static int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int[] numstat = new int[26];
        for (int i=0;i< chars.length;i++) {
            int index = chars[i] - 'a';
            numstat[index] = numstat[index] +1;
        }

        for (int k=0; k< chars.length;k++) {
            if (numstat[chars[k]-'a'] == 1) {
                return k;
            }
        }
        return -1;
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        Map<Integer, Integer> temp = new HashMap<>();
        Deque deque = new ArrayDeque();
        for (int i =0; i< chars.length;i++) {
            if (temp.containsKey(chars[i]- 'a')) {
                max = Math.max(max, deque.size());
                while ((char)deque.peek() != chars[i]) {
                    char tempChar = (char)deque.poll();
                    temp.remove(tempChar-'a');
                }
                deque.poll();
                deque.addLast(chars[i]);

            } else {
                temp.put(chars[i]- 'a', 1);
                deque.addLast(chars[i]);
            }
        }
        return Math.max(max, deque.size());

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2== null) {
            return l1;
        }
        ListNode index1 = l1;
        ListNode index2 = l2;
        ListNode root = new ListNode(-1);
        ListNode temp = root;
        while (index1 != null && index2 != null) {
            if (index1.val <= index2.val) {
                ListNode listNode = new ListNode(index1.val);
                temp.next = listNode;
                index1 = index1.next;
                temp = temp.next;
            } else {
                ListNode listNode = new ListNode(index2.val);
                temp.next = listNode;
                index2 = index2.next;
                temp = temp.next;
            }
        }
        if (index1 == null) {
            temp.next = index2;
            return root.next;
        }
        if (index2 == null) {
            temp.next = index1;
            return root.next;
        }
        return root.next;

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

     static class ListNode {
         int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }
    public static void main(String[] args) {
//        System.out.println(wordPattern("abba", "dog cat cat dog"));
//        System.out.println(wordPattern("abba", "dog cat cat fish"));
//        System.out.println(wordPattern("aaaa", "dog cat cat dog"));
//        System.out.println(wordPattern("abba", "dog dog dog dog"));
//        System.out.println(wordPattern("ab", "dog dog"));
//        System.out.println(firstUniqChar("leetcode"));
//        System.out.println(firstUniqChar("loveleetcode"));
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(2);
        ListNode listNode13 = new ListNode(4);
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(3);
        ListNode listNode23 = new ListNode(4);
        listNode21.next = listNode22;
        listNode22.next = listNode23;

        System.out.println(mergeTwoLists(listNode11, listNode21));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
