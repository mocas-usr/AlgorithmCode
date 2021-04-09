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
        //起始搜索
        boolean res = dfs(root.left, root.right);
        return res;

    }

    public boolean dfs(TreeNode left, TreeNode right) {

        //终止条件
        if (left==null ||right==null)
        {
            if (left == null&&right==null) {
                return true;
            }
            return false;
        }

        //选择列表
        boolean r1 = left.val == right.val ? true : false;
        boolean r2 = dfs(left.right, right.left);
        boolean r3 = dfs(left.left, right.right);

        if (r1 && r2 && r3) {
            return true;
        } else {
            return false;
        }


        //下一路径
        //恢复现场


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
