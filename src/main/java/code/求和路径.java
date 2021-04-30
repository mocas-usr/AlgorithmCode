package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/22 上午10:17
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-22 10:17
 */
public class 求和路径 {
    //全局变量
    int total=0;
    int res=0;
    public int pathSum(TreeNode root, int sum) {
        //终止路径
        if (root==null)
        {
            return 0;
        }
        pathSum(root.left,sum);
        dfs(root,sum);
        pathSum(root.right,sum);
        return res;

    }

    public void dfs(TreeNode root,int sum)
    {
        //终止条件
        if (root==null)
        {
            return;
        }
        // 当前路径
        total=total+root.val;
        //剪枝
        if (total==sum)
        {
            res+=1;
        }

        //for 循环列表
        dfs(root.left,sum);
        dfs(root.right,sum);


        // 下一路径
        //恢复现场
        total=total-root.val;


    }

    @Test
    public void test() {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node42 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node52 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        node5.left = node4;
        node5.right = node8;
        node4.left = node11;
        node8.left = node13;
        node8.right = node42;
        node11.left = node7;
        node11.right = node2;
        node42.left = node52;
        node42.right = node1;
        int res=pathSum( node5,22);
        System.out.println(res);


    }
}
