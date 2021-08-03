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

    public static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            //前序
            if (root == null) {
                return "null";
            }

            String left = serialize(root.left);
            String right = serialize(root.right);
            String res = root.val + "," + left + "," + right;
            return res;

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.length() == 0) {
                return null;
            }
            Queue<String> queue = new LinkedList<>();

            String[] str = data.split(",");

            for (String s : str) {

                queue.add(s);
            }
            return dfs(queue);
        }

        public TreeNode dfs(Queue<String> queue) {

            String s = queue.poll();
            //终止条件
            if (s.equals("null")) {

                return null;
            }
            int val = Integer.parseInt(s);
            TreeNode root = new TreeNode(val);
            TreeNode left = dfs(queue);
            TreeNode right = dfs(queue);
            root.left = left;
            root.right = right;
            return root;
        }

    }

    public static void main(String[] args) {

// Your Codec object will be instantiated and called as such:
        Codec codec = new Codec();

        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node3.left = node4;
        node3.right = node5;
        String s=codec.serialize(root);
        TreeNode node=codec.deserialize(s);
        System.out.println(node);
    }


}
