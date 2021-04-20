package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/12 下午7:20
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-12 19:20
 */
public class 二叉搜索树中第K小的元素 {

    LinkedList<Integer> list=new LinkedList<>();
    public int kthSmallest(TreeNode root, int k) {
        if (root==null)
        {
            return -1;
        }
        dfs(root);
        int res=list.get(k-1);
        return res;

    }

    public void dfs(TreeNode root)
    {
        if (root==null)
        {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}
