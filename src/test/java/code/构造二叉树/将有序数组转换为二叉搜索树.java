package code.构造二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/8 下午3:39
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-08 15:39
 */
public class 将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }

        TreeNode root = helpTree(nums, 0, nums.length - 1);
        return root;
    }

    public TreeNode helpTree(int[] nums, int left, int right) {
        if (nums.length == 0) {
            return null;
        }
        if (left>right)
        {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helpTree(nums, left, mid - 1);
        root.right = helpTree(nums, mid + 1, right);
        return root;
    }
}
