package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/9 下午7:30
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-09 19:30
 */
public class 二叉树最大宽度 {
    //层次遍历
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int width = 1;
        int index = 1;
        root.val = index;
        while (!queue.isEmpty()) {
            int size = queue.size();
            width=Math.max(width,queue.peekLast().val-queue.peekFirst().val+1);
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    node.left.val = 2 * node.val + 1;
                    queue.offer(node.left);

                }
                if (node.right != null) {
                    node.right.val =2 * node.val + 2;
                    queue.offer(node.right);
                }
                size--;
            }




        }
        return width;

    }

    @Test
    public void test()
    {
        TreeNode root=new TreeNode(-1);
        TreeNode node1=new TreeNode(-1);
        TreeNode node2=new TreeNode(-1);
        root.left=node1;
        root.right=node2;
        int res=widthOfBinaryTree(root);
        System.out.println(res);
    }





}

