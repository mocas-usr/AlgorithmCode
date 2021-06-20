package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 下午4:12
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-17 16:12
 */
public class 对称的二叉树 {


    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot==null)
        {
            return true;
        }

        boolean res=isSym(pRoot.left,pRoot.right);
        return res;
    }

    public boolean isSym(TreeNode left,TreeNode right)
    {
        if (left==right)
        {
            return true;
        }
        if (left==null || right==null)
        {
            return false;
        }

        boolean val=false;
        if (left.val==right.val)
        {
            val=true;
        }

        return val && isSym(left.right,right.left) &&isSym(left.left,right.right);
    }
}
