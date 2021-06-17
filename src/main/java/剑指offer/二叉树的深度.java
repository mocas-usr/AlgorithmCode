package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/16 下午8:57
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-16 20:57
 */
public class 二叉树的深度 {

    public int TreeDepth(TreeNode root) {
        //终止条件
        if (root==null)
        {
            return 0;
        }
        //当前选择
        int maxDepth=1;
        //下一路径
        int left=TreeDepth(root.left);
        int right=TreeDepth(root.right);
        maxDepth=Math.max(left,right)+1;
        return maxDepth;

    }
}
