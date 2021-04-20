package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/10 下午3:30
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-10 15:30
 */
public class 从中序与后序遍历序列构造二叉树 {

    Map<Integer, Integer> map = new HashMap<>();
    int[] post;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        TreeNode root = helper(0, inorder.length - 1, 0, postorder.length - 1);
        return root;

    }

    public TreeNode helper(int inLeft, int inRight, int poLeft, int poRight) {

        //终止条件
        if (inRight<inLeft || poLeft>poRight)
        {
            return null;
        }
        //for 选择列表
        int val=post[poRight];
        TreeNode node=new TreeNode(val);
        int mid=map.get(val);//root在中序遍历的位置

        node.left=helper(inLeft,mid-1,poLeft,poLeft+mid-1-inLeft);
        node.right=helper(mid+1,inRight,poLeft+mid-inLeft,poRight-1);
        return node;

    }

    public class TreeNode {
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
}
