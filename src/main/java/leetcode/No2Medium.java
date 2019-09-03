package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author machao
 */
public class No2Medium {
    //定义常量，避免魔法值
    private static final int TEN = 10;

    public static void main(String[] args) {
        System.out.println(addTwoNumbers(makeUpListNodes(1909), makeUpListNodes(999)));
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            l1 = new ListNode(0);
        }
        if(l2 == null){
            l2 = new ListNode(0);
        }

        int temp = l1.val + l2.val;

        ListNode ret = new ListNode(0);
        if(temp >= TEN ){
            ret.val = temp - TEN;
            ret.next = addTwoNumbers(new ListNode(1),addTwoNumbers(l1.next,l2.next));
        }else{
            ret.val = temp;
            ret.next = addTwoNumbers(l1.next,l2.next);
        }
        return ret;
    }

    /**
     * 组装listNode，根据给定的整数拼装listNode链表
     * @param numb 随便一个整数
     * @return listNode链表
     */
    private static ListNode makeUpListNodes(int numb){
        List<ListNode> listNodes = new ArrayList<>();
        String num = String.valueOf(numb);
        for(int i = num.length() - 1 ; i >= 0 ; i--){
            String n = String.valueOf(num.charAt(i));
            ListNode ln = new ListNode(Integer.parseInt(n));
            int size = listNodes.size();
            if( size > 0){
                listNodes.get(size-1).next = ln;
                listNodes.add(ln);
            }else{
                listNodes.add(ln);
            }
        }
        return listNodes.get(0);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        this.val = x;
    }
    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}