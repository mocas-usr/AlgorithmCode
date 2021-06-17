package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 下午8:46
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 20:46
 */
public class 二叉搜索树与双向链表 {
    TreeNode pre=null;
    TreeNode cur;
    TreeNode head;
    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null) {
            return null;
        }

        Convert(pRootOfTree.left);
        //当前选择
        if (pre==null)
        {
            //说明是第一个节点
            head=pRootOfTree;
            pre=pRootOfTree;
            cur=pRootOfTree;
        }else
        {

            cur=pRootOfTree;
            pre.right=cur;
            cur.left=pre;
            pre=cur;

        }
        Convert(pRootOfTree.right);
        return head;

    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    @Test
    public void test()
    {
//        TreeNode node10=new
    }

}



