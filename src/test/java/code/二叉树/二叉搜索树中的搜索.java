package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/3 上午9:29
 * @email: wangyuhang_mocas@163.com
 */

import com.sun.org.apache.xerces.internal.impl.dv.xs.AnyURIDV;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-03 09:29
 */
public class 二叉搜索树中的搜索 {

    public TreeNode searchBST(TreeNode root, int val) {
        //终止条件
        if (root == null) {
            return null;
        }
        //当前路径
        if (root.val > val) {
            return searchBST(root.left,val);
        }else if (root.val<val)
        {
            return searchBST(root.right,val);
        }else
        {
            return root;
        }

    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
