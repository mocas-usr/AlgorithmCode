package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/10 21:23
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-10 21:23
 */
public class 二叉树的最大深度 {
    public int maxDepth(TreeNode root) {

        //终止条件
        if (root==null)
        {
            return 0;
        }
        //for选择列表

        //做选择

        //下一路径
        int left=maxDepth(root.left)+1;
        int right=maxDepth(root.right)+1;
        //恢复现场
        int max=Math.max(left,right);
        return max;
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
