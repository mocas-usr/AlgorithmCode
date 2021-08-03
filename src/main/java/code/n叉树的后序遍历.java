package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/8/2 下午4:12
 * @email: wangyuhang_mocas@163.com
 */

import java.util.*;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-08-02 16:12
 */
public class n叉树的后序遍历 {

    List<Integer> res = new LinkedList<>();

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }

        dfs(root);
        return res;

    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }

        for (Node child : root.children) {
            dfs(child);

        }

        res.add(root.val);

    }

    public List<Integer> postorder2(Node root) {
        if (root == null) {
            return new LinkedList<>();
        }

        List<Integer> res = new LinkedList<>();
        //中间右边左边
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);

            for (Node child : node.children) {
                stack.push(child);
            }

        }
        Collections.reverse(res);
        return res;
    }

}
