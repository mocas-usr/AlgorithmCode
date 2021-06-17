package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/3 上午9:28
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-03 09:28
 */
public class 将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0) {
            return null;
        }

        return helpTree(nums, 0, nums.length - 1);

    }

    public TreeNode helpTree(int[] nums, int left, int right) {
        //终止条件
        if (left > right) {
            return null;
        }
        //当前选择
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        //下一路径
        node.left = helpTree(nums, left, mid - 1);
        node.right = helpTree(nums, mid + 1, right);
        //恢复现场

        return node;
    }

    @Test
    public void test() {
        int[] nums = {-10, -3, 0, 5, 9};
        sortedArrayToBST(nums);
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
