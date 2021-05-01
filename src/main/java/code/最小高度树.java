package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/19 下午8:03
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-19 20:03
 */
public class 最小高度树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length==0)
        {
            return null;
        }

        return helper(nums,0,nums.length-1);

    }

    public TreeNode helper(int[] nums,int left,int right)
    {
        if (left>right)
        {
            return null;
        }

        int mid=left+(right-left)/2;

        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,left,mid-1);
        root.right=helper(nums,mid+1,right);
        return root;
    }
}
