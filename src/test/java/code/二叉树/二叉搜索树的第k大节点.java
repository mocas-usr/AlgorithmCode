package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/14 下午2:55
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-14 14:55
 */
public class 二叉搜索树的第k大节点 {

    public int kthLargest(TreeNode root, int k) {

        if (root==null)
        {
            return -1;
        }
        ArrayList<Integer> list=new ArrayList<>();
        dfs(root,list);
        return list.get(k-1);
    }

    public void dfs(TreeNode root,ArrayList<Integer> list)
    {
        if (root==null)
        {
            return;
        }
        dfs(root.right,list);
        list.add(root.val);
        dfs(root.left,list);


    }


    @Test
    public void test() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node3.left = node1;
        node3.right = node4;
        node1.right = node2;
        kthLargest(node3, 2);
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
