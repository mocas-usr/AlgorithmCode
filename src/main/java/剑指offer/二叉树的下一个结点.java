package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 下午3:55
 * @email: wangyuhang_mocas@163.com
 */

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-17 15:55
 */
public class 二叉树的下一个结点 {

    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }


    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        //先查看是否右子节点是否为空
        //不为空白的话，dfs(root)
        if (pNode.right != null) {
            return dfs(pNode.right);
        } else {
            //找靠左边的parent
            return leftParent(pNode);
        }
        //先查看节点的位置

    }

    public TreeLinkNode dfs(TreeLinkNode root) {

        TreeLinkNode left = root.left;
        if (left == null) {
            return root;
        } else {
            return dfs(root.left);
        }
    }

    public TreeLinkNode leftParent(TreeLinkNode pNode) {

        //当前操作
        TreeLinkNode par = pNode.next;
        if (par == null) {
            return null;
        }
        //如果当前节点是左边节点，则返回par
        if (pNode.equals(par.left)) {
            return par;
        }
        //下一路径
        return leftParent(par);
    }

    @Test
    public void test() {

    }
}
