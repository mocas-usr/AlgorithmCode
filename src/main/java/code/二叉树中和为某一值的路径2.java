package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/4 上午10:13
 * @email: wangyuhang_mocas@163.com
 */

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.junit.Test;
import org.omg.CORBA.IMP_LIMIT;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-04 10:13
 */
public class 二叉树中和为某一值的路径2 {

    List<List<Integer>> result=new LinkedList<>();//结果集
    List<Integer> list=new LinkedList<>();//存放顺序
    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {

        int total=0;//记录当前路径和
        dfs(root,sum,total);
        return result;
    }

    //递归，回溯
    public void dfs(TreeNode root,int sum,int total)
    {
        if (root==null)
        {
            return;
        }
        //终止条件
        list.add(root.val);
        total=total+root.val;
        //满足条件的路径，已经进行到最后的叶子节点
        if (root.left==null &&root.right==null)
        {
            if (total==sum)
            {
                result.add(new LinkedList<>(list));//创建新对象，这样有效避免对象的更改

            }
            //进行到叶子节点后，要进行返回，回溯
            list.remove(list.size()-1);
            return;
        }
        dfs(root.left,sum,total);
        dfs(root.right,sum,total);
        //这里进行回溯
        //这里已经开始往回返回
        list.remove(list.size()-1);
    }


    @Test
    public void test()
    {
        TreeNode node1=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node5=new TreeNode(5);
        TreeNode node7=new TreeNode(7);
        TreeNode node4=new TreeNode(4);
        TreeNode node11=new TreeNode(11);
        TreeNode node13=new TreeNode(13);
        TreeNode node42=new TreeNode(4);
        TreeNode node8=new TreeNode(8);
        TreeNode node52=new TreeNode(5);

        node52.left=node42;
        node52.right=node8;
        node42.left=node11;
        node11.left=node7;
        node11.right=node2;
        node8.right=node4;
        node8.left=node13;
        node4.left=node5;
        node4.right=node1;
        pathSum(node52,22);

    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
