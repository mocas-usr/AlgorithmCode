package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/9 上午10:11
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-09 10:11
 */
public class 二叉树中的最大路径和 {
    //两次遍历变一次
    //全局变量
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return res;

    }

    //求各节点的和
    public int dfs(TreeNode root)
    {
        if (root==null)
        {
            return 0;
        }
        //下一路径
        int left=Math.max(0,dfs(root.left));
        int right=Math.max(0,dfs(root.right));
        //当前选择
        int sum=root.val+left+right;

        res=Math.max(res,sum);
        int num=root.val+Math.max(left,right);
        return num;
    }
}

class TreeNode {
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
