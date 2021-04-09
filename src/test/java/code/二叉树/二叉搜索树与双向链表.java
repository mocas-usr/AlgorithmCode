package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/9 下午4:42
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-09 16:42
 */
public class 二叉搜索树与双向链表 {

    Node head = null;
    Node cur = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        //起始搜索
        search(root);
        head.left=cur;
        cur.right=head;
        return head;

    }


    public void search(Node root) {
        //终止条件
        if (root == null) {
            return;
        }

        //for 循环列表
        //下一路径
        search(root.left);
        if (cur==null)
        {
            head=root;
        }
        Node pre=cur;
        cur=root;
        if (pre!=null)
        {
            pre.right=cur;
            cur.left=pre;
        }

        //当前操作
        //恢复现场
        search(root.right);

    }


    @Test
    public void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        //
        node4.left = node2;
        node4.right = node5;
        node2.left = node1;
        node2.right = node3;
        treeToDoublyList(node4);

    }

}


class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}