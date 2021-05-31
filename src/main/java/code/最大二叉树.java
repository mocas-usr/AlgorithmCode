package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/27 下午8:29
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-27 20:29
 */
public class 最大二叉树 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {

        if (nums.length == 0) {
            return null;
        }
        int max = nums[0];
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode left = helpTree(nums, 0, maxIndex - 1);
        TreeNode right = helpTree(nums, maxIndex + 1, nums.length - 1);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = left;
        root.right = right;
        return root;

    }

    public TreeNode helpTree(int[] nums, int left, int right) {
        if (nums.length == 0) {
            return null;
        }
        if (left < 0 || left >= nums.length || right < 0 || right >= nums.length) {
            return null;
        }
        if (left > right) {
            return null;
        }
        int max = nums[left];
        int maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode leftNode = helpTree(nums, left, maxIndex - 1);
        TreeNode rightNode = helpTree(nums, maxIndex + 1, right);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    @Test
    public void test() {
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode res = constructMaximumBinaryTree(nums);
        System.out.println(res);
    }
}
