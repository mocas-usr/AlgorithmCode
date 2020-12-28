package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/11 下午7:49
 * @email: wangyuhang_mocas@163.com
 */

import javax.security.auth.login.AccountLockedException;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-11 19:49
 */
public class 树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //判断特异性
        if(A==null || B==null)
        {
            return false;
        }
        //遍历所有节点，找到开始比较的节点
        //开始递归处理，寻找开始遍历的点
        if (dfs(A,B) || isSubStructure(A.left,B) ||isSubStructure(A.right,B))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //判断从此子节点开始是否相等
    public Boolean dfs(TreeNode A, TreeNode B)
    {
        //遍历时，如果b先为空，则为true，
        if (B==null)
        {
            return true;
        }
        //如果b不为空，而a为空，则false
        if (A==null)
        {
            return false;
        }

        if (A.val==B.val && dfs(A.left,B.left) && dfs(A.right,B.right))
        {
            return true;
        }else
        {
            return false;
        }

    }
}
