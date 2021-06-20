package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 下午4:55
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-17 16:55
 */
public class 二叉搜索树的第k个结点 {
    TreeNode KthNode(TreeNode pRoot, int k) {

        if (pRoot == null) {
            return null;
        }

        List<TreeNode> res = new LinkedList<>();



        dfs(pRoot, res);
        if (k>res.size() ||k==0)
        {
            return null;
        }
        return res.get(k-1);

    }

    public void dfs(TreeNode root, List<TreeNode> res) {
            if (root==null)
            {
                return;
            }
            dfs(root.left,res);
            res.add(root);
            dfs(root.right,res);
    }

}
