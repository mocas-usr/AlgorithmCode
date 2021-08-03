package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/21 下午5:05
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-21 17:05
 */
public class 二叉树的右视图 {

    public List<Integer> rightSideView(TreeNode root) {

        if (root == null) {
            return new LinkedList<>();
        }
        List<Integer> res=new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index=0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (size==1)
                {
                    res.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
        }
        return res;

    }
}
