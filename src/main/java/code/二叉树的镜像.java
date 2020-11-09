package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/7 下午3:52
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-07 15:52
 */
public class 二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null)
            return null;

        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        mirrorTree(root.right);
        mirrorTree(root.left);
        return root;

    }

    //用栈写
    public TreeNode mirrorTree2(TreeNode root)
    {
        if (root==null)
        {
            return null;
        }
        //构建栈
        Stack<TreeNode> stack=new Stack();
        stack.add(root);
        while (!stack.isEmpty())
        {
            //前序遍历
            TreeNode temp=stack.pop();
            if (temp.left!=null)
            {
                stack.add(temp.left);
            }
            if (temp.right!=null)
            {
                stack.add(temp.right);
            }
            //用于交换的中转栈
            TreeNode tmp=temp.left;
            temp.left=temp.right;
            temp.right=tmp;
        }
        return root;

    }


    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
    }
}
