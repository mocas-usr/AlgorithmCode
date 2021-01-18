package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/14 15:33
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-14 15:33
 */
public class 二叉树展开为链表 {
    public void flatten(TreeNode root) {

        //终止条件
        if (root==null)
        {
            return;
        }

        //后续搜索路径
        flatten(root.left);
        flatten(root.right);

        TreeNode tmp=root.right;
        root.right=root.left;
        root.left=null;

        while (root.right!=null)
        {
            root=root.right;
        }
        root.right=tmp;


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
