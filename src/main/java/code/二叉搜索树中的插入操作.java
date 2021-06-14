package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/11 下午9:20
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-11 21:20
 */
public class 二叉搜索树中的插入操作 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //边界
        if (root == null) {
            return null;
        }
        TreeNode cur = root;

        while (true) {
            //val在左子树
            if (cur.val > val) {

                //
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur.left = new TreeNode(val);
                    return root;
                }
            } else {//val在右子树
                if (cur.right!=null)
                {
                    cur=cur.right;
                }else
                {
                    cur.right=new TreeNode(val);
                    return root;
                }
            }
        }
    }
}
