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

    public int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }
        //当前选择
        //下一路径
        int left=Math.max(dfs(root.left),0);
        int right=Math.max(dfs(root.right),0);
        int sum=root.val+left+right;
        res=Math.max(res,sum);
        //恢复现场
        return root.val+Math.max(left,right);

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
