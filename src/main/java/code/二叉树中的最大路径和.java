package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/8 下午8:06
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-08 20:06
 */
public class 二叉树中的最大路径和 {
    int res = Integer.MIN_VALUE;

    //遍历所有节点
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }


        dfs(root);
        return res;


    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //剪枝
        //for 循环列表
        // 当前路径
        //下一路径
        int left = Math.max(dfs(root.left),0);
        int right = Math.max(dfs(root.right),0);

        int sum=root.val+left+right;
        res=Math.max(sum,res);

        // 恢复现场
        return root.val+Math.max(left,right);

    }


    @Test
    public void test() {
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;


        int res = maxPathSum(node1);
        System.out.println(res);

    }

}
