package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/3 下午4:12
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-03 16:12
 */
public class 二叉树中和为某一值的路径 {
    public int  val=0;
    //存放结果
    List<Integer> res=new LinkedList<>();
    List<List<Integer>> list=new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root==null)
        {
            return null;
        }

        searchSum(root,sum);
        return list;

    }
    public void searchSum(TreeNode root,int sum)
    {
        if (root==null)
        {
            return;
        }

        //终止条件
        res.add(root.val);
        val=val+root.val;
        if (val==sum )
        {
            list.add(res);
            return;
        }
        //搜索左边
        else if (val<sum)
        {
            searchSum(root.left,sum);
            searchSum(root.right,sum);
        }
        else if (val>sum)
        {
            res.clear();
            return;
        }


    }

    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), result);
        return result;
    }

    public void dfs(TreeNode root, int sum, List<Integer> list,
                    List<List<Integer>> result) {
        //如果节点为空直接返回
        if (root == null)
            return;
        //因为list是引用传递，为了防止递归的时候分支污染，我们要在每个路径
        //中都要新建一个subList
        List<Integer> subList = new ArrayList<>(list);
        //把当前节点值加入到subList中
        subList.add(new Integer(root.val));
        //如果到达叶子节点，就不能往下走了，直接return
        if (root.left == null && root.right == null) {
            //如果到达叶子节点，并且sum等于叶子节点的值，说明我们找到了一组，
            //要把它放到result中
            if (sum == root.val)
                result.add(subList);
            //到叶子节点之后直接返回，因为在往下就走不动了
            return;
        }
        //如果没到达叶子节点，就继续从他的左右两个子节点往下找，注意到
        //下一步的时候，sum值要减去当前节点的值
        dfs(root.left, sum - root.val, subList, result);
        dfs(root.right, sum - root.val, subList, result);
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
        pathSum2(node52,22);

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
