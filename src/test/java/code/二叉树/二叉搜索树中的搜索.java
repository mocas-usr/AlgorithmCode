package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/3 上午9:29
 * @email: wangyuhang_mocas@163.com
 */

import com.sun.org.apache.xerces.internal.impl.dv.xs.AnyURIDV;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-03 09:29
 */
public class 二叉搜索树中的搜索 {

    public TreeNode searchBST(TreeNode root, int val) {
        //终止条件
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        //循环列表
        //当前选择
        else if (root.val > val) {
            return searchBST(root.left, val);
        } else if (root.val < val) {
            return searchBST(root.right, val);
        }
        //下一路径
        //恢复现场
        return null;

    }

    public TreeNode searchBST2(TreeNode root, int val) {
        //返回子树就是返回子树的root
        if (root == null)
            return null;
        if (root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else if (val > root.val) {
            return searchBST(root.right, val);
        }
        return null;

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
