package leetcode.util;

/**
 * @author machao
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    /**
     * 组装listNode，根据给定的整数拼装listNode链表
     *
     * @param numb 随便一个整数，整数的每一位都是链表的节点。
     * @return listNode链表
     */
    public static ListNode makeUpListNodes(int numb) {
        ListNode res = null;
        String num = String.valueOf(numb);
        for (int i = num.length() - 1; i >= 0; i--) {
            String n = String.valueOf(num.charAt(i));
            ListNode ln = new ListNode(Integer.parseInt(n));
            ln.next = res;
            res = ln;
        }
        return res;
    }

    public static ListNode makeUpListNodes(int from, int to) {
        ListNode res = new ListNode(to);
        while (res.val > from) {
            ListNode listNode = new ListNode(res.val - 1);
            listNode.next = res;
            res = listNode;
        }
        return res;
    }

}
