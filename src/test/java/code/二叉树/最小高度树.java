package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/19 下午8:10
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-19 20:10
 */
public class 最小高度树 {
    public TreeNode sortedArrayToBST(int[] nums) {

        if (nums.length == 0) {
            return null;
        }

        return helpTree(nums, 0, nums.length - 1);
    }

    public TreeNode helpTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (right - left) / 2 + left;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helpTree(nums, left, mid - 1);
        root.right = helpTree(nums, mid + 1, right);
        return root;
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
