package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/15 下午4:50
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import javax.sound.sampled.EnumControl;
import java.util.*;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-15 16:50
 */
public class 二叉搜索树的后序遍历序列 {


    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length == 0) {
            return true;
        }
        boolean res = dfs(postorder, 0, postorder.length - 1);
        return res;

    }

    public boolean dfs(int[] nums, int left, int right) {
        //终止条件
        if (left > right) {
            return true;
        }

        TreeNode root = new TreeNode(nums[right]);
        int rootval = nums[right];
        int index = left;
        while (index < right && nums[index] < rootval) {
            index++;
        }
        for (int i=index;i<right;i++)
        {
            if (nums[i]<rootval)
            {
                return false;
            }
        }
        return dfs(nums,left,index-1)&&dfs(nums,index,right-1);
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode prev = null;
        List<Integer> list = new ArrayList<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                if (node.right == null || node.right == prev) {
                    prev = node;
                    list.add(node.val);
                    node = null;
                } else {
                    stack.push(node);
                    node = node.right;
                }
            }
        }
        return list;

    }


    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        //
        node4.left = node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;
        List<Integer> list = postorderTraversal(node4);
        System.out.println(list);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
