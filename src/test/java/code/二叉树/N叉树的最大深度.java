package code.二叉树;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/3 上午9:27
 * @email: wangyuhang_mocas@163.com
 */

import java.util.List;

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
        int maxDep=Integer.MIN_VALUE;

        //遍历子节点
        for (Node child:root.children)
        {
            //递归搜寻
            maxDep=Math.max(maxDep,maxDepth(child)+1);
        }
        return maxDep;


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
