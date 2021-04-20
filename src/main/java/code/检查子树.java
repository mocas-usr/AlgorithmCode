package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/18 下午8:29
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-18 20:29
 */
public class 检查子树 {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        //终止条件
        if (t2==null)
        {
            return true;
        }
        if (t1==null)
        {
            return false;
        }
        //下一路径
        return isTreeEqual(t1,t2) || checkSubTree(t1.left,t2) ||checkSubTree(t1.right,t2);


    }


    public boolean isTreeEqual(TreeNode t1,TreeNode t2)
    {
        if (t1==t2)
        {

            return true;
        }
        if (t1==null || t2==null)
        {
            return false;
        }

        return t1.val==t2.val &&isTreeEqual(t1.left,t2.left) &&isTreeEqual(t1.right,t2.right);
    }
}
