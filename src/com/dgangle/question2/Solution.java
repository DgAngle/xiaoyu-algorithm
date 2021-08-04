package com.dgangle.question2;

/**
 * LeetCode, 2: 两数相加
 *
 * @Author gqshuang
 * @Date 2021/5/25 13:00
 * @Version 1.0
 */
public class Solution {
    /*
        给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
        请你将两个数相加，并以相同形式返回一个表示和的链表。
        你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

        示例 1：
            输入：l1 = [2,4,3], l2 = [5,6,4]
            输出：[7,0,8]
            解释：342 + 465 = 807.
        示例 2：
            输入：l1 = [0], l2 = [0]
            输出：[0]
        示例 3：
            输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
            输出：[8,9,9,9,0,0,0,1]

        提示：
            - 每个链表中的节点数在范围 [1, 100] 内
            - 0 <= Node.val <= 9
            - 题目数据保证列表表示的数字不含前导零
    
        来源：力扣（LeetCode）
        链接：https://leetcode-cn.com/problems/add-two-numbers
        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    */

    /**
     * 通过 (参考官方思路 + 题解)
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0); // 根节点
        ListNode tail = head; // 尾节点
        int carry = 0; // 进位
        while (l1 != null || l2 != null || carry > 0) {
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        return head.next;
    }

    /**
     * 超出内存限制
     */
    public static ListNode addTwoNumbers_old1(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode tempNode;
        listNode.val = l1.val + l2.val; // 第一位数字相加
        tempNode = listNode;
        while (l1.next != null) {
            l1 = l1.next;
            int temp = 0;
            // 处理相加的值
            if (tempNode.val >= 10) {
                temp = 1;
                tempNode.val -= 10;
            }
            if (l2.next != null) {
                l2 = l2.next;
                tempNode.next = new ListNode(l1.val + l2.val + temp);
            } else {
                tempNode.next = new ListNode(l1.val + temp);
            }
            tempNode = tempNode.next;
        }

        while (l2.next != null) {
            int temp = 0;
            // 处理相加的值
            if (tempNode.val > 10) {
                temp = 1;
                tempNode.val -= 10;
            }
            tempNode.next = new ListNode(l2.val + temp);
            tempNode = tempNode.next;
        }
        if (tempNode.val >= 10) {
            tempNode.val -= 10;
            tempNode.next = new ListNode(1);

        }
        return listNode;
    }

    /**
     * 链表结果打印
     */
    public static void printNode(ListNode listNode) {
        System.out.print("[ ");
        while (listNode.next != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
        System.out.print(listNode.val + " ]");
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//        ListNode l1 = new ListNode(0);
//        ListNode l2 = new ListNode(0);
//        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
//        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        printNode(l1);
        printNode(l2);
        System.out.print("\n 结果：");
        ListNode listNode = addTwoNumbers(l1, l2);
        printNode(listNode);
    }
}
