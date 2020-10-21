package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/18 上午9:56
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-18 09:56
 */
/*
给定二叉搜索树（BST）的根节点和一个值。
        你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
*/

public class 二叉搜索树中的搜索 {
    //递归
    public TreeNode searchBST(TreeNode root, int val) {
        //如果节点值相等或者为空,root==null,则说明搜索结束，搜索结果为null
        if (root.val == val || root == null) {
            return root;
        }
        if (val < root.val) {
            //如果搜索数值小于root.val
            return searchBST(root.left, val);

        } else {
            return searchBST(root.right, val);
        }

    }

    //迭代查找
    public TreeNode searchBST2(TreeNode root, int val) {
        //如果root不满足，则往下移动
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
        }
        return root;

    }
}


//Definition for a binary tree node.
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x)
//    { val = x; }
//}
