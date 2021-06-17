package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/16 下午9:18
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-16 21:18
 */
public class 平衡二叉树 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        //当前选择
        boolean left = IsBalanced_Solution(root.left);
        boolean right = IsBalanced_Solution(root.right);
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        boolean mid = false;
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            mid = true;
        } else {
            mid = false;
        }
        //下一路径
        return mid && left && right;

    }

    public int dfs(TreeNode root) {
        if (root==null)
        {
            return 0;
        }
        int depth=1;
        int left=dfs(root.left);
        int right=dfs(root.right);
        depth=Math.max(left,right)+1;
        return depth;
    }
}
