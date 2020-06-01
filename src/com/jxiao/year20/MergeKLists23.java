package com.jxiao.year20;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class MergeKLists23 {



    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0 || lists==null){
            return null;
        }

        PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });


        for (int i = 0; i <lists.length ; i++) {
            while (lists[i]!=null){
                queue.add(lists[i]);
                lists[i] = lists[i].next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode head=dummy;

        while (!queue.isEmpty()){
            dummy.next = queue.poll();
            dummy = dummy.next;
        }
        dummy.next = null;


        return head.next;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}


