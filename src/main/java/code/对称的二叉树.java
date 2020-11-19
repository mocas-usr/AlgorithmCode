package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/9 下午3:58
 * @email: wangyuhang_mocas@163.com
 */

import javax.swing.*;
import java.util.LinkedList;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-09 15:58
 */
public class 对称的二叉树 {

    LinkedList<TreeNode> list1=new LinkedList<>();
    LinkedList<TreeNode> list2=new LinkedList<>();

    public boolean isSymmetric(TreeNode root) {
        if (root==null)
        {
            return true;
        }
        inorder(root);
        afterOrder(root);
        for (int i=0;i<list1.size();i++)
        {
            if (list1.get(i)!=list2.get(i))
            {
                return false;
            }
        }
        return true;

    }

    //中序遍历
    public void inorder(TreeNode root)
    {
        if (root==null)
        {
            return;
        }

        inorder(root.left);
        list1.add(root.left);
        list1.add(root);
        inorder(root.right);
        list1.add(root.right);

    }

    //先右后中最后左边
    public void afterOrder(TreeNode root)
    {
        if (root==null)
        {
            return;
        }
        afterOrder(root.right);
        list2.add(root.right);
        list2.add(root);
        afterOrder(root.left);
        list2.add(root.left);
    }



    public boolean isSymmetric2(TreeNode root)
    {
        if (root==null)
        {
            return true;
        }
        return isSymmetricJudge(root.left,root.right);


    }


    public boolean isSymmetricJudge(TreeNode left,TreeNode right)
    {
        if (right==null || left==null)
        {
            //只有同时 为空,才为true
            if (left==null && right==null)
            {
                return true;
            }
            return false;
        }

        if (right.val!=left.val)
        {
            return false;
        }
        return isSymmetricJudge(left.left,right.right) &&isSymmetricJudge(left.right,right.left);
    }



       public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
   }
}
