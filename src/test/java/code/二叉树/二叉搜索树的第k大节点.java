package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/14 下午2:55
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-14 14:55
 */
public class 二叉搜索树的第k大节点 {
    public int kthLargest(TreeNode root, int k) {
        //特值处理
        if (root==null)
        {
            return -1;
        }
        //排放所有节点
        List<Integer> list=new LinkedList<>();
        searchTree(root,list);
        int res=list.get(k-1);
        return res;

    }

    //求k大，则中序遍历反过来
    public void searchTree(TreeNode node,List list)
    {
        if (node==null)
        {return;}
        //
        searchTree(node.right,list);
        list.add(node.val);
        searchTree(node.left,list);
    }


    @Test
    public void test()
    {
        TreeNode node4=new TreeNode(4);
        TreeNode node3=new TreeNode(3);
        TreeNode node2=new TreeNode(2);
        TreeNode node1=new TreeNode(1);
        node3.left=node1;
        node3.right=node4;
        node1.right=node2;
        kthLargest(node3,2);
    }


       public class TreeNode {
        int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
  }
}
