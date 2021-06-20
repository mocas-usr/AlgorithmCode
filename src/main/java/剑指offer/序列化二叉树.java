package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 下午4:47
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-17 16:47
 */
public class 序列化二叉树 {

    String Serialize(TreeNode root) {

        if (root == null) {
            return "null";
        }
        return root.val + "," + Serialize(root.left) + "," + Serialize(root.right);
    }

    TreeNode Deserialize(String str) {

        //利用前序遍历
        String[] s = str.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String s1 : s) {
            queue.add(s1);
        }
        return dfs(queue);

    }

    public TreeNode dfs(Queue<String> queue)
    {
        String val=queue.poll();
        //当前选择
        if ("null".equals(val))
        {
            return null;
        }
        TreeNode root=new TreeNode(Integer.valueOf(val));
        root.left=dfs(queue);
        root.right=dfs(queue);
        return root;

    }


}
