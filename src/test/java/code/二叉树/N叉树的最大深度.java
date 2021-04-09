package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/3 上午9:27
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-03 09:27
 */
public class N叉树的最大深度 {

    public int maxDepth(Node root) {
        //终止条件
        if (root == null) {
            return 0;
        }
        int maxDepth=1;
        //for 循环列表
        for (Node node : root.children) {
            //当前选择
            //下一路径
            maxDepth=Math.max(maxDepth,maxDepth(node)+1);
        }


        //恢复现场

        return maxDepth;

    }

    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> children = new LinkedList<>();
        children.add(node3);
        children.add(node2);
        children.add(node4);
        List<Node> children2 = new LinkedList<>();
        children2.add(node5);
        children2.add(node6);
        node1.children = children;
        node3.children = children2;
        node5.children = new LinkedList<>();
        node6.children = new LinkedList<>();
        node2.children = new LinkedList<>();
        node4.children = new LinkedList<>();
        maxDepth(node1);
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
