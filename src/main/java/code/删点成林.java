package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/8 上午10:10
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-08 10:10
 */
public class 删点成林 {

    List<TreeNode> res = new LinkedList<>();
    HashSet<Integer> set = new HashSet<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {


        for (int node : to_delete) {
            set.add(node);
        }

        if (!set.contains(root.val)) {
            res.add(root);
        }

        dfs(root);
        return res;

    }

    //后序遍历
    public TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if (set.contains(root.val)) {
            if (root.left != null) {
                res.add(root.left);
            }
            if (root.right != null) {
                res.add(root.right);
            }
            root = null;
        }
        return root;
    }
}
