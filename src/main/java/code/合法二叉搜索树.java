package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/20 下午6:38
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Stack;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-20 18:38
 */
public class 合法二叉搜索树 {
    TreeNode pre;

    //中序遍历
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        //访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;

    }

    //中序遍历非递归
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode node=root;

        while (node != null || !stack.isEmpty()) {
            while (node!= null)
            {
                stack.push(node);
                node=node.left;
            }
            //中间的
            node=stack.pop();
            if (pre!=null &&node.val<=pre.val)
            {
                return false;
            }
            pre=node;
            node=node.right;

        }
        return true;
    }
}
