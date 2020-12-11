package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/20 上午11:19
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-20 11:19
 */
public class 从上到下打印二叉树 {
    public int[] levelOrder(TreeNode root) {
        if (root==null)
        {
            return new int[0];
        }

        //保存节点
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        List<Integer> res=new LinkedList<>();//存放结果
        //如果队列不为空
        while (!queue.isEmpty())
        {
            int size=queue.size();//本层节点的个数

            //遍历本层节点
            while (size>0)
            {
                TreeNode node=queue.poll();//本层节点出队列
                res.add(node.val);//保存结果
                if (node.left!=null){queue.add(node.left);}
                if (node.right!=null){queue.add(node.right);}
                size--;
            }
        }
        int [] result=new int[res.size()];
        for (int i=0;i<res.size();i++)
        {
            result[i]=res.get(i);
        }
        return result;


    }
       public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
