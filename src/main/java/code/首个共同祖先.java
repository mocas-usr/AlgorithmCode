package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/20 下午6:25
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-20 18:25
 */
public class 首个共同祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //终止条件
        if(root==null)
        {
            return null;
        }
        if (root==p ||root==q)
        {
            return root;
        }

        //当前选择
        //下一路径
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        //当前选择
        if (left==null)
        {
            return right;
        }
        if (right==null)
        {
            return left;
        }

        return root;


    }
}
