package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 上午9:38
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.TreeMap;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 09:38
 */
public class 重建二叉树 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {

        if (pre.length == 0) {
            return null;
        }

        return helpTree(pre, 0, pre.length - 1, in, 0, in.length - 1);

    }

    public TreeNode helpTree(int[] pre, int preLeft, int preRight, int[] in, int inLeft, int inRight) {
        //终止条件

        //终止条件有问题
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        int index = inLeft;
        while (index <= inRight) {
            if (in[index] == pre[preLeft]) {
                break;
            }
            index++;

        }
        int len = index - inLeft;
        root.left = helpTree(pre, preLeft + 1, preLeft +len, in, inLeft, index - 1);
        root.right = helpTree(pre, preLeft+1+len, preRight, in, index + 1, inRight);
        return root;
    }

    @Test
    public void test() {
        int[] pre={1,2,4,3,5,6};
        int[] in={4,2,1,5,3,6};

        TreeNode res=reConstructBinaryTree( pre,  in);
        System.out.println(res);
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
