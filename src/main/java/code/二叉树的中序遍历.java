package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/12 11:31
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-12 11:31
 */
public class 二叉树的中序遍历 {

    //全局变量
    List<Integer> res=new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root==null)
        {
            return new LinkedList<>();
        }
        //起始搜索
        dfs(root);
        return res;
    }
    //递归
    public void dfs(TreeNode root)
    {
        //终止条件
        if (root==null)
        {
            return;
        }
        //剪枝
        //for 选择列表
        if (root.left!=null)
        {
            dfs(root.left);
        }
        //做选择
        res.add(root.val);

        //下一路径
        if (root.right!=null)
        {
            dfs(root.right);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
