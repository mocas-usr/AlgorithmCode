package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/13 14:07
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-13 14:07
 */
public class 二叉树的层序遍历 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        //结果集
        List<List<Integer>> res=new LinkedList<>();

        if (root==null)
        {
            return new LinkedList<>();
        }
        //队列
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            //这一层有几个节点
            int size=queue.size();
            List<Integer> list=new LinkedList<>();//本层的结果
            while (size>0)
            {
                TreeNode node=queue.poll();
                list.add(node.val);
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
            res.add(new LinkedList<>(list));
        }
        return res;

    }




      public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
