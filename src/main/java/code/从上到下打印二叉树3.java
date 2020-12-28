package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/13 下午7:03
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-13 19:03
 */
public class 从上到下打印二叉树3 {

    //广度搜索
    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root==null)
        {
            //返回空
            return new LinkedList<>();
        }

        int depth=0;
        //存储节点
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        //存放结果集
        List<List<Integer>> res=new LinkedList<>();
        while (!queue.isEmpty())
        {
            depth++;//第几层
            //每层含有的节点数量
            int size=queue.size();
            //保存此层的节点数值
            List<Integer> list=new LinkedList<>();
            //遍历此层所有的节点
            while (size>0)
            {

                //入队列都是从左到右
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

            //如果是奇数层
            if (depth%2!=1)
            {
                //反转list
                list=reverse(list);
            }
            res.add(new LinkedList<>(list));

        }
        return res;
    }

    public List<Integer> reverse(List<Integer> list)
    {
        List<Integer> res=new LinkedList<>();
        for (int i=list.size()-1;i>=0;i--)
        {
            res.add(list.get(i));
        }

        return res;
    }


    @Test
    public void test()
    {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node3.right=node5;
        levelOrder(node1);
    }

      public class TreeNode {
      int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
