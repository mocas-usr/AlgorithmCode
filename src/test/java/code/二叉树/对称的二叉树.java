package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/9 下午4:19
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-09 16:19
 */
public class 对称的二叉树 {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
        boolean res = dfs(root.left, root.right);
        return res;
    }

    public boolean dfs(TreeNode left, TreeNode right) {
        if (left == right) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        //当前路径
        boolean ans1 = left.val == right.val ? true : false;
        boolean ans2 = dfs(left.left, right.right);
        boolean ans3 = dfs(left.right, right.left);
        return ans1 && ans2 && ans3;
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
