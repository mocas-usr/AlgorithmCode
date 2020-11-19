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
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-03 09:27
 */
public class N叉树的最大深度 {
    public int maxDepth(Node root){
        if (root==null)
        {
            return 0;
        }
        int maxDepth=1;//必须是1，因为保证最下面一层的高度是1
        for (Node node:root.children)
        {
            maxDepth=Math.max(maxDepth(node)+1,maxDepth);
        }
        return maxDepth;


    }

    public int maxDepth2(Node root) {  //层序遍历解法
        if (root==null)
        {
            return 0;
        }
        if (root.children==null)
        {
            return 1;
        }
        int depth=0;
        Queue<Node> queue= new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            //本层的节点数量
            int size=queue.size();

            //深度加1
            depth++;

            while (size>0)
            {
                //遍历本层节点
                Node node=queue.poll();
                //将下一层的加入
                if (node.children!=null)
                {
                    for (Node node1:node.children)
                    {
                        queue.add(node1);
                    }

                }
                size--;//这一层的
            }

        }
        return depth;
    }

    @Test
    public void test()
    {
        Node node1=new Node(1);
        Node node3=new Node(3);
        Node node2=new Node(2);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        List<Node> children=new LinkedList<>();
        children.add(node3);
        children.add(node2);
        children.add(node4);
        List<Node> children2=new LinkedList<>();
        children2.add(node5);
        children2.add(node6);
        node1.children=children;
        node3.children=children2;
        node5.children=new LinkedList<>();
        node6.children=new LinkedList<>();
        node2.children=new LinkedList<>();
        node4.children=new LinkedList<>();
        maxDepth2(node1);
    }



    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
