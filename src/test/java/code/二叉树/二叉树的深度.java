package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/6 上午10:12
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;
import org.omg.CORBA.MARSHAL;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-06 10:12
 */
public class 二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //当前选择
        int maxDepth = 1;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        maxDepth = Math.max(left, right) + 1;
        return maxDepth;
    }

    //bfs，队列实现
    public int maxDepth2(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int width = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            width++;
            while (size > 0) {

                TreeNode node=queue.poll();
                if (node.left!=null)
                {
                    queue.add(node.left);
                }
                if (node.right!=null)
                {
                    queue.add(node.right);
                }
                size--;
            }

        }

        return width;
    }


    @Test
    public void test() {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        int num = maxDepth2(node3);
        System.out.println(num);


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
