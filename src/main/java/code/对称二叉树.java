package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/12 21:47
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-12 21:47
 */
public class 对称二叉树  {

    public boolean isSymmetric(TreeNode root) {

        if (root==null)
        {
            return true;
        }
        //搜索起点


        return dfs(root.left,root.right);

    }


    public boolean dfs(TreeNode left,TreeNode right)
    {
        //终止条件
        if (left==right)
        {
            return  true;
        }
        //剪枝
        if (right==null || left==null)
        {
            return false;
        }


        //for 选择列表
        //做选择，选择下一路径
        boolean res=((left.val==right.val)&&(dfs(left.left,right.right))&&dfs(left.right,right.left));
        return res;

    }

    public class TreeNode {
      int val;
       TreeNode left;
     TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
