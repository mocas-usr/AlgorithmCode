package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/8 下午5:12
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-08 17:12
 */
public class 平衡二叉树 {

    public boolean isBalanced(TreeNode root) {

        //
        if (root == null) {
            return true;
        }
        //下一路径
        boolean leftAns = isBalanced(root.left);
        boolean rightAns = isBalanced(root.right);
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        boolean ans = false;
        if (Math.abs(left - right) <= 1) {
            ans = true;
        }

        return leftAns && rightAns && ans;

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int max = 1;
        max = Math.max(left, right) + 1;
        return max;

    }

    public boolean isBalanced2(TreeNode root) {


        return helpTree(root)!=-1;
    }

    public int helpTree(TreeNode root)
    {
        //
        if (root==null)
        {return 0;}
        int left=helpTree(root.left);
        if (left==-1)
        {
            return -1;
        }
        int right=helpTree(root.right);
        if (right==-1)
        {
            return -1;
        }

        if (Math.abs(left-right)>1)
        {
            return -1;
        }
        return Math.max(left,right)+1;
    }
}
