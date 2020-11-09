package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/6 上午10:04
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Map;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-06 10:04
 */
public class 二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if (root==null)
        {
            return 0;
        }
        int depth=1;
        if (root.left!=null)
        {
            depth=Math.max(maxDepth(root.left)+1,depth);
        }
        if (root.right!=null)
        {
            depth=Math.max(maxDepth(root.right)+1,depth);
        }
        return depth;

    }

    //最简单的递归
    public int maxDepth2(TreeNode root)
    {
        if (root==null)
        {
            return 0;
        }
        int left=maxDepth(root.left)+1;
        int right=maxDepth(root.right)+1;
        int res=Math.max(left,right);
        return res;
    }
}
