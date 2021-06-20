package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 上午11:31
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 11:31
 */
public class 树的子结构 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        //终止条件
        if (root1 == null || root2 == null) {
            return false;
        }

        // ab全不为空

        //递归搜索是否相同
        //查询是否子节点包含
        boolean left = HasSubtree(root1.left, root2);
        boolean right = HasSubtree(root1.right, root2);
        boolean mid = dfs(root1, root2);
        return mid || left || right;
    }


    public boolean dfs(TreeNode root1, TreeNode root2) {
        //2先为空
        if (root2 == null) {
           return true;
        }
        if (root1==null)
        {
            return false;
        }
        boolean mid = false;
        if (root1.val == root2.val) {
            mid = true;
        }
        boolean left = dfs(root1.left, root2.left);
        boolean right = dfs(root1.right, root2.right);

        return mid && left && right;
    }


}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
