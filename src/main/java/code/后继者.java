package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/11 下午8:17
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-11 20:17
 */
public class 后继者 {
    TreeNode res;
    TreeNode pre = null;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        res = null;
        if (root == null) {
            return null;
        }

        dfs(root, p);
        return res;

    }

    public void dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        dfs(root.left, p);
        if (p != null && pre != null && pre.val == p.val) {
            res = root;
        }
        pre = root;
        dfs(root.right, p);

    }

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
     node5.left=node3;
     node5.right=node6;
     node3.left=node2;
     node3.right=node4;
     node2.left=node1;
        TreeNode res = inorderSuccessor(node5, node1);
        System.out.println(res);
    }
}
