package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/22 下午2:55
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-22 14:55
 */
public class 检查平衡性 {
    Boolean flag=true;
    //双重dfs
    public boolean isBalanced(TreeNode root) {
        //终止条件
        if (root==null)
        {
            return true;
        }
        //检查每个节点的高度
        dfs(root);
        return flag;

    }

    public int dfs(TreeNode root)
    {
        //终止条件
        if (root==null)
        {
            return 0;
        }
        int left=dfs(root.left);
        int right=dfs(root.right);
        if (Math.abs(left-right)>1)
        {
            flag=false;
        }

        int maxDepth=Math.max(left,right)+1;
        return maxDepth;

    }
}
