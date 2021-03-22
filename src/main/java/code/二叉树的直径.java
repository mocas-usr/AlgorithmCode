package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/27 21:14
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-27 21:14
 */
public class 二叉树的直径 {
    //全局变量
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans=1;
        //起始搜索
        dfs(root);
        return ans-1;

    }

    public int dfs(TreeNode root)
    {
        //终止条件
        if (root==null)
        {
            return 0;
        }
        //for 选择列表
        int left=dfs(root.left);//左子树的深度
        int right=dfs(root.right);//右子树的深度
        //做选择
        ans=Math.max(ans,left+right+1);//结果取最大，不断更新结果
        //下一列表

        //恢复现场
        return Math.max(left,right)+1;//返回以root为节点得深度


    }
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
