package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/17 下午4:24
 * @email: wangyuhang_mocas@163.com
 */


/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-17 16:24
 */
/*
将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

        本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
*/

public class 将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return helpTree(nums, 0, nums.length - 1);

    }

    //构造二叉树
    public TreeNode helpTree(int[] nums, int left, int right) {

        //
        if (left > right) {
            return null;
        }
        //选取中间偏左的节点为root
        int mid = (left + right) / 2;
        //开始构造
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helpTree(nums, left, mid - 1);
        root.right = helpTree(nums, mid + 1, right);
        return root;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
