package code.二叉树;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/11 下午8:18
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-12-11 20:18
 */
public class 二叉树中和为某一值的路径 {
    //全局变量
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> list = new LinkedList<>();
    int sum;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new LinkedList<>();
        }
        //起始搜索
        sum = 0;
        dfs(root, target);
        return res;


    }

    public void dfs(TreeNode root, int target) {
        //终止条件
        if (root == null) {
            return;
        }
        list.add(root.val);
        sum = sum + root.val;
        if (sum == target && root.left == null && root.right == null) {
            List<Integer> relist = new LinkedList<>(list);
            res.add(relist);
        }
        //for循环列表
        if (root.left != null) {

            dfs(root.left, target);
        }

        //当前选择
        //下一路径
        if (root.right != null) {
            dfs(root.right, target);
        }
        //恢复现场
        list.remove(list.size() - 1);
        sum = sum - root.val;

    }

    @Test
    public void test() {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node42 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node52 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        node5.left = node4;
        node5.right = node8;
        node4.left = node11;
        node8.left = node13;
        node8.right = node42;
        node11.left = node7;
        node11.right = node2;
        node42.left = node52;
        node42.right = node1;
        List<List<Integer>> res = pathSum(node5, 22);
        System.out.println(res);


    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
