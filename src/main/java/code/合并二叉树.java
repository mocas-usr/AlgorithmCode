package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/21 21:34
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-01-21 21:34
 */
public class 合并二叉树 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
       if (t1==null)
       {
           return t2;
       }
       if (t2==null)
       {
           return t1;
       }

        TreeNode node=new TreeNode(t1.val+t2.val);

        //下一路径
        node.left=mergeTrees(t1.left,t2.left);
        node.right=mergeTrees(t1.right,t2.right);
        //恢复现场
        return node;

    }

    @Test
    public void test()
    {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val)   {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
