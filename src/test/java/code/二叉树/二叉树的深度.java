package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/6 上午10:12
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-06 10:12
 */
public class 二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if (root==null)
        {
            return 0;
        }
        int leftDepth=maxDepth(root.left)+1;
        int rightDepth=maxDepth(root.right)+1;

        int depth=Math.max(leftDepth,rightDepth);
        return depth;
    }

    //bfs，队列实现
    public int maxDepth2(TreeNode root)
    {
        if (root==null)
        {
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();//用于存储节点
        queue.add(root);
        int depth=0;
        int size=0;
        while (!queue.isEmpty())
        {
            size=queue.size();//一层几个节点

            depth++;
            while (size>0)
            {
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
        return depth;
    }


    @Test
    public void test()
    {
        TreeNode node3=new TreeNode(3);
        TreeNode node9=new TreeNode(9);
        TreeNode node20=new TreeNode(20);
        TreeNode node15=new TreeNode(15);
        TreeNode node7=new TreeNode(7);
        node3.left=node9;
        node3.right=node20;
        node20.left=node15;
        node20.right=node7;
        maxDepth(node3);


    }

   public class TreeNode {
       int val;
     TreeNode left;
     TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
