package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/14 下午2:52
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-14 14:52
 */
public class 平衡二叉树 {

    public boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        int height = dfs(root);
        if (height != -1) {
            return true;
        } else {
            return false;
        }
    }

    //
    public int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int maxDepth = 1;
        int left = dfs(root.left);
        if (left == -1) {
            return -1;
        }
        int right = dfs(root.right);
        if (right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }
        maxDepth = Math.max(left, right) + 1;
        return maxDepth;
    }



}
