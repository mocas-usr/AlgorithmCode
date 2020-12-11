package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/18 上午9:04
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-18 09:04
 */
/*给定一个 N 叉树，找到其最大深度。

        最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。*/

public class N叉树的最大深度 {
    //递归,时间复杂度o(n)，空间复杂度最坏o(n)
    public int maxDepth2(Node root) {
        //处理特殊情况
        if (root == null) {
            return 0;

        }
        if (root.children.isEmpty()) {
            return 1;
        }

        //处理一般情况
        List<Integer> list = new LinkedList<>();
        //遍历子节点
        for (Node node : root.children) {
            //将子节点的高度加入
            list.add(maxDepth(node));
        }
        //求出集合最大值
        int maxDepth = Collections.max(list);
        return maxDepth;

    }

    //递归，用math.max函数
    public int maxDepth(Node root) {

        if (root == null) {
            return 0;
        }
        int maxDepth = 1;

        //开始深度优先取最大
        for (Node node : root.children) {
            //每个节点深度
            maxDepth = Math.max(maxDepth, 1 + maxDepth(node));

        }
        return maxDepth;
    }

    //queue队列求解，迭代法
    public int maxDepth3(Node root)
    {
        if (root==null)
        {
            return 0;
        }
        //保存节点
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);//加入root
        //默认深度
        int depth=0;
        while (!queue.isEmpty())
        {
            //深度++
            depth++;
            int size=queue.size();//queue的深度
            while (size>0)
            {
                Node temp=queue.poll();
                //将这个node的子节点加入
                for (Node node:temp.children)
                {
                    queue.add(node);
                }
                size--;
            }

        }

        return depth;

    }
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
