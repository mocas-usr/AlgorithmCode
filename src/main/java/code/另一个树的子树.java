package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/27 下午7:56
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-27 19:56
 */
public class 另一个树的子树 {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            if (subRoot == null) {
                return true;
            } else {
                return false;
            }
        }
        //下一路径
        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);
        boolean nodeVal = dfs(root, subRoot);

        return nodeVal || left || right;

    }

    public boolean dfs(TreeNode root, TreeNode subRoot) {
        // 同时为空 说明树一起到底，两树相同
        if (root == null && subRoot == null) {
            return true;
        }
        // 如果上面没有返回值，说明必有一个没有为空（有可能两个都不为空）
        if (root == null || subRoot == null) {
            return false;
        }

        //当前选择
        if (root.val != subRoot.val) {
            return false;
        }
        //下一路径

        return dfs(root.right, subRoot.right) && dfs(root.left, subRoot.left);


    }
}
