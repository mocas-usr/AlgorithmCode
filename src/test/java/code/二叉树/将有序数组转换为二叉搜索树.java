package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/3 上午9:28
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-03 09:28
 */
public class 将有序数组转换为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums)
    {
        return helpTree(nums,0,nums.length-1);

    }

    public TreeNode helpTree(int[] nums,int left,int right)
    {
        if (left>right)
        {
            return null;
        }
        //中点
        int mid=left+(right-left)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helpTree(nums,left,mid-1);
        root.right=helpTree(nums,mid+1,right);
        return root;
    }

    @Test
    public void test()
    {
        int[] nums={ -10,-3,0,5,9};
        sortedArrayToBST(nums);
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }
}
