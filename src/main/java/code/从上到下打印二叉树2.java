package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/10 上午9:47
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-10 09:47
 */
public class 从上到下打印二叉树2 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null)
        {
            return new ArrayList<>();
        }
        List<List<Integer>> res=new LinkedList<>();//结果存放
        Queue<TreeNode> queue=new LinkedList<>();//存放打印的节点
        queue.add(root);

        while (!queue.isEmpty())
        {
            List<Integer> list=new ArrayList<>();
            //加入队列,代表某一层
            for (int i=queue.size();i>0;i--)
            {
                TreeNode node=queue.poll();//这一层的node
                list.add(node.val);
                if (node.left!=null)
                {
                    queue.add(node.left);
                }
                if (node.right!=null)
                {
                    queue.add(node.right);
                }

            }
            res.add(list);

        }

        return res;


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
        levelOrder3(node3);

    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null) queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }



}
