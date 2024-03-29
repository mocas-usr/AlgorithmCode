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
public class 前序遍历构造二叉搜索树 {
    public TreeNode bstFromPreorder(int[] preorder) {

        if (preorder.length == 0) {
            return null;
        }
        TreeNode root=helpTree(preorder, 0, preorder.length - 1);
        return root;
    }

    public TreeNode helpTree(int[] nums, int left, int right) {
        if (left>right)
        {
            return null;
        }

        TreeNode root=new TreeNode(nums[left]);
        int index=left+1;
        while (index<=right && nums[index]<nums[left])
        {
            index++;
        }
        //此时是右子树
        root.left=helpTree(nums,left+1,index-1);
        root.right=helpTree(nums,index,right);
        return root;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
