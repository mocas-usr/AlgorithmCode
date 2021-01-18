package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/13 17:19
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-13 17:19
 */
public class 验证二叉搜索树 {

        TreeNode node;//这个相当于中序遍历指针
    public boolean isValidBST(TreeNode root) {
        //终止条件
        if (root==null)
        {
            return true;
        }
        //做选择
        //路径变换
        //中序遍历

        boolean left=isValidBST(root.left);
        boolean mid=true;
        //做选择
        if (node!=null && root.val<=node.val)
        {
            mid=false;
        }
        node=root;
        boolean right=isValidBST(root.right);

        return left&&mid&&right ;

    }



    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
          this.left = left;
           this.right = right;
       }
   }
}
