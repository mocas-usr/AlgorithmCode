package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/9 下午4:42
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-09 16:42
 */
public class 二叉搜索树与双向链表 {
    Node pre=null;
    Node head=null;
    public Node treeToDoublyList(Node root) {
        //最小的数值
        if (root==null)
        {
            return null;
        }
        search(root);
        //执行结束时
        pre.right=head;
        head.left=pre;
        return head;
    }

    //中序遍历
    public void search(Node cur)
    {
        if (cur==null)
        {
            return;
        }
        //左
        search(cur.left);
        //根
        //回溯
        if (pre!=null)//即第一个跳出时
        {
            pre.right=cur;
        }else
        {
            head=cur;//第一个节点
        }

        cur.left=pre;
        pre=cur;

        //右
        search(cur.right);
        return;
    }


    @Test
    public void test()
    {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);

        //
        node4.left=node2;
        node4.right=node5;
        node2.left=node1;
        node2.right=node3;
        treeToDoublyList(node4);

    }

}



class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}