package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/8 下午3:29
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-08 15:29
 */
public class 前序遍历构造二叉搜索树 {

    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder.length == 0) {
            return null;
        }

        TreeNode root = helpTree(preorder, 0, preorder.length - 1);
        return root;

    }

    public TreeNode helpTree(int[] nums, int left, int right) {
        if (nums.length == 0) {
            return null;
        }

        if (left > right) {
            return null;
        }

        TreeNode root = new TreeNode(nums[left]);
//        if (left == right) {
//            return root;
//        }

        int i = left ;
        while (i <=right && nums[left] >= nums[i]) {
            i++;
        }
        root.left = helpTree(nums, left + 1, i - 1);
        root.right = helpTree(nums, i, right);
        return root;
    }

    @Test
    public void test() {
        int[] preorder=new int[]{4,2};
        TreeNode res=bstFromPreorder(preorder);
        System.out.println(res);
    }
}
