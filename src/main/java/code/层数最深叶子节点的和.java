package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/31 下午4:19
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-31 16:19
 */
public class 层数最深叶子节点的和 {


    public int deepestLeavesSum(TreeNode root) {

        if (root==null)
        {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum=0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            sum=0;
            while (size > 0) {
                TreeNode node=queue.poll();
                sum+=node.val;
                if (node.left!=null)
                {
                    queue.offer(node.left);
                }
                if (node.right!=null)
                {
                    queue.offer(node.right);
                }
                size--;
            }
        }
        return sum;
    }
}
