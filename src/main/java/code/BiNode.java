package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/2 下午9:29
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-02 21:29
 */
public class BiNode {
    TreeNode pre = null;
    TreeNode head= new TreeNode(-1);

    public TreeNode convertBiNode(TreeNode root) {

        if (root == null) {
            return null;
        }
        dfs(root);
        return head.right;

    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre==null)
        {
            head.right=root;
            pre=root;
        }else
        {
            pre.right = root;
            pre = root;
        }
        root.left=null;

        dfs(root.right);

    }


    @Test
    public void test() {
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node3.left = node1;
        node3.right = node4;
        node1.right = node2;
        TreeNode res=convertBiNode(node3);
        System.out.println(res);
    }
}
