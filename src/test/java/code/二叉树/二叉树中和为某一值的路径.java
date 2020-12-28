package code.二叉树;

/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/11 下午8:18
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-11 20:18
 */
public class 二叉树中和为某一值的路径 {
    List<List<Integer>> result=new LinkedList<>();//结果集
    List<Integer> list=new LinkedList<>();//存放顺序

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        if (root==null)
        {
            return new LinkedList<>();
        }
        //深度搜索
        int total=0;
        dfs(root,total,sum);
        return result;


    }

    //前序遍历，回溯
    public void dfs(TreeNode root,int total,int sum)
    {

        if (root==null)
        {
            return;
        }
        //处理和
        list.add(root.val);
        total+=root.val;
        if (root.left==null &&root.right==null)
        {
            if (sum==total)
            {
                result.add(new LinkedList<>(list));
            }
            //结束之后进行，要进行回溯
            list.remove(list.size()-1);//去除最后添加的元素回溯
            return;
        }

        dfs(root.left,total,sum);
        dfs(root.right,total,sum);
        //执行完才会回溯
        list.remove(list.size()-1);//去除最后添加的元素回溯
    }

    @Test
    public void test()
    {
        TreeNode node5=new TreeNode(5);
        TreeNode node4=new TreeNode(4);
        TreeNode node8=new TreeNode(8);
        TreeNode node11=new TreeNode(11);
        TreeNode node13=new TreeNode(13);
        TreeNode node42=new TreeNode(4);
        TreeNode node7=new TreeNode(7);
        TreeNode node2=new TreeNode(2);
        TreeNode node52=new TreeNode(5);
        TreeNode node1=new TreeNode(1);
        node5.left=node4;
        node5.right=node8;
        node4.left=node11;
        node8.left=node13;
        node8.right=node42;
        node11.left=node7;
        node11.right=node2;
        node42.left=node52;
        node42.right=node1;
        pathSum(node5,22);



    }



       public class TreeNode {
      int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

}
