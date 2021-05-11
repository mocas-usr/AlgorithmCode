package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/7 下午7:10
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-07 19:10
 */
public class 序列化二叉树 {

    public class Codec {


        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "[]";
            }
            StringBuilder st = new StringBuilder();
            st.append("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            //
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    if (node != null) {
                        st.append(node.val);
                        st.append(",");
                        queue.offer(node.left);
                        queue.offer(node.right);
                    } else {
                        st.append("null,");
                    }
                    size--;

                }


            }
            //去掉逗号
            st.deleteCharAt(st.length() - 1);
            st.append("]");
            return st.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("[]")) {
                return null;
            }

            StringBuilder str = new StringBuilder();
            //拆分成数组
            String[] s = data.substring(1, data.length() - 1).split(",");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.valueOf(s[0]));
            queue.offer(root);
            //记录遍历的字符数组
            int i = 1;
            while (!queue.isEmpty()&&i<s.length) {
                //这一层节点数
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    if (!s[i].equals("null")) {
                        TreeNode temp = new TreeNode(Integer.valueOf(s[i]));
                        queue.offer(temp);
                        node.left = temp;
                    }
                    //处理下一个数据
                    i++;
                    if (!s[i].equals("null")) {
                        TreeNode temp = new TreeNode(Integer.valueOf(s[i]));
                        queue.offer(temp);
                        node.right = temp;
                    }
                    i++;
                    size--;
                }

            }
           return root;

        }
    }


    @Test
    public void test() {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        Codec codec = new Codec();
       String data= "[1,2,3,null,null,4,5]";
        TreeNode root= codec.deserialize( data);
        System.out.println(root);
    }
}
