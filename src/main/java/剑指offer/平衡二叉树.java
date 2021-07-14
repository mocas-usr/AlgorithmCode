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
        //高度
        int res=dfs(root);
        //下一路径
        return res!=-1;

    }

    //其中出现一个不符合条件的子树，就把-1传过来
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        int left = dfs(root.left);
        if (left == -1) {
            return -1;
        }
        int right = dfs(root.right);
        if (right == -1){
            return -1;
        }
        if (Math.abs(left-right)>1)
        {
            return -1;
        }
        depth=Math.max(left,right)+1;
        return depth;
    }
}
