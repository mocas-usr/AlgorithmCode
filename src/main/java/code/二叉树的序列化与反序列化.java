package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/9 下午3:01
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-09 15:01
 */
public class 二叉树的序列化与反序列化 {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root==null)
            {
                return "[]";
            }

            Queue<TreeNode> queue = new LinkedList<>();
            StringBuilder str = new StringBuilder();
            str.append("[");
            queue.offer(root);

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    TreeNode node = queue.poll();
                    if (node != null) {
                        str.append(node.val);
                        str.append(",");
                        queue.offer(node.left);
                        queue.offer(node.right);
                    } else {
                        str.append("null,");
                    }
                    size--;
                }

            }

            str.deleteCharAt(str.length() - 1);
            str.append("]");
            return str.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("[]"))
            {
                return null;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            StringBuilder str = new StringBuilder();
            String[] arr=data.substring(1,data.length()-1).split(",");

            TreeNode root=new TreeNode(Integer.valueOf(arr[0]));
            queue.offer(root);
            int i=1;//标记到哪个数据了

            while (!queue.isEmpty())
            {
                int size=queue.size();
                while (size>0)
                {
                    TreeNode node=queue.poll();
                    if (!arr[i].equals("null"))
                    {
                        TreeNode temp=new TreeNode(Integer.valueOf(arr[i]));
                        node.left=temp;
                        queue.offer(temp);
                    }
                    i++;
                    if (!arr[i].equals("null"))
                    {
                        TreeNode temp=new TreeNode(Integer.valueOf(arr[i]));
                        node.right=temp;
                        queue.offer(temp);
                    }
                    i++;
                    size--;

                }
            }

            return root;

        }
    }
}
