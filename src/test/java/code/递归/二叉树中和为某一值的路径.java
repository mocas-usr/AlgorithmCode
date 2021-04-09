package code.递归;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/7 下午5:16
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-07 17:16
 */
public class 二叉树中和为某一值的路径 {

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> list = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new LinkedList<>();
        }
        int total = 0;
        dfs(root, target, total);
        return res;

    }

    public void dfs(TreeNode root, int target, int total) {
        //终止条件
        if (root==null)
        {
            return;
        }
        //做选择
        list.add(root.val);
        total=total+root.val;
        if (total==target&&root.left==null &&root.right==null)
        {
            res.add(new LinkedList<>(list));
        }
        //下一路径
        if (root.left!=null)
        {
            dfs(root.left,target,total);
        }
        if (root.right!=null)
        {
            dfs(root.right,target,total);
        }
        //恢复现场
        list.remove(list.size()-1);

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
        pathSum(node5, 22);


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
