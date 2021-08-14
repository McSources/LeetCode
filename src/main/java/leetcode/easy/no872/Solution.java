package leetcode.easy.no872;

import java.util.ArrayList;
import java.util.List;

/**
 * @author machao
 * @date 2021/5/10
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
        TreeNode treeNodeRight = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4)));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1List = getLeaf(root1);
        List<Integer> root2List = getLeaf(root2);
        return root1List.equals(root2List);
    }

    private List<Integer> getLeaf(TreeNode treeNode) {
        List<Integer> ret = new ArrayList<>();
        if (treeNode == null) {
            return ret;
        }
        if (null == treeNode.right && null == treeNode.left) {
            ret.add(treeNode.val);
        } else {
            ret.addAll(getLeaf(treeNode.right));
            ret.addAll(getLeaf(treeNode.left));
        }
        return ret;
    }

}
