package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/20 下午7:29
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-20 19:29
 */
public class 路径总和2 {
    List<List<Integer>> res = new LinkedList<>();
    int total;
    List<Integer> list;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return new LinkedList<>();
        }
        list = new LinkedList<>();
        total = 0;
        dfs(root, targetSum);
        return res;


    }


    public void dfs(TreeNode root, int sum) {
        //终止条件
        if (root == null) {
            return;
        }
        //for 循环列表
        //当前选择
        //剪枝
        total += root.val;
        list.add(root.val);
        if (total == sum && root.left == null && root.right == null) {
            res.add(new LinkedList<>(list));
        }

        //下一路径
        dfs(root.left, sum);
        dfs(root.right, sum);
        //恢复现场
        list.remove(list.size() - 1);
        total -= root.val;


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
}
