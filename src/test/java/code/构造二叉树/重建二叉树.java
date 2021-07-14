package code.构造二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 上午10:02
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 10:02
 */
public class 重建二叉树 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }


        TreeNode root = helpTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        return root;

    }


    public TreeNode helpTree(int[] pre, int preLeft, int preRight, int[] in, int inLeft, int inRight) {

        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }


        int index = inLeft;
        while (index <= inRight && in[index] != pre[preLeft]) {
            index++;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        int len = index - inLeft;
        root.left = helpTree(pre, preLeft + 1, preLeft + len, in, inLeft, index - 1);
        root.right = helpTree(pre, preLeft + 1 + len, preRight, in, index + 1, inRight);
        return root;

    }

    @Test
    public void test() {
        int[] pre={1,2,4,3,5,6};
        int[] in={4,2,1,5,3,6};

        TreeNode res=buildTree( pre,  in);
        System.out.println(res);
    }
}
