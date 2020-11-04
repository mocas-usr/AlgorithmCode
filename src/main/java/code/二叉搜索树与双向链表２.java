package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/3 上午10:35
 * @email: wangyuhang_mocas@163.com
 */

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-03 10:35
 */
public class 二叉搜索树与双向链表２ {
    Node pre,head;//pre遍历，head指向头节点

    public Node treeToDoublyList(Node root)
    {

        if (root==null)
        {
            return null;
        }
        dfs(root);
        //head指向头部，最左
        head.left=pre;
        pre.right=head;
        return head;

    }


    //中序遍历,双指针遍历
    public void dfs(Node cur)
    {
        //遍历结束条件
        if (cur==null)
        {
            return;
        }
        //遍历左节点

        dfs(cur.left);
        //中间节点的处理
        if (pre==null)//如果为空，则说明是头部节点，最左边节点
        {
            head=cur;
        }else
        {
            //cur是pre的下一个节点
            pre.right=cur;
        }

        cur.left=pre;
        pre=cur;

        //遍历右边
        dfs(cur.right);
    }


    //普通中序遍历
    public Node treeToDoublyList2(Node root)
    {
        if (root==null)
        {
            return null;
        }
        //存储所有节点，按照顺序
        ArrayList<Node> nodes=new ArrayList<>();
        inorder(nodes,root);
        Node head;//用于指向头部
        Node pre;//用于遍历
        head=nodes.get(0);
        pre=head;
        for (int i=1;i<nodes.size();i++)
        {
            Node node=nodes.get(i);
            pre.right=node;
            node.left=pre;
            pre=node;

        }
        head.left=pre;
        pre.right=head;
        return head;

    }
    public void inorder(List<Node> nodes,Node TreeNode)
    {
        //终止条件
        if (TreeNode==null)
        {
            return;
        }
        //遍历左边
        inorder(nodes,TreeNode.left);
        //中间处理
        nodes.add(TreeNode);
        //后序遍历
        inorder(nodes,TreeNode.right);

    }
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,  Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
