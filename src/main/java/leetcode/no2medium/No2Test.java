package leetcode.no2medium;

import java.util.ArrayList;
import java.util.List;

public class No2Test {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addTwoNumbers(makeUpListNodes(1909), makeUpListNodes(999)));
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
