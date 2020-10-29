package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/23 下午6:39
 * @email: wangyuhang_mocas@163.com
 */

import java.util.*;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-23 18:39
 */
public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //递归搜索,搜索到叶节点之下，就返回null
        if (root==null)
        {
            return  null;
        }
        //搜索到root为q或者p，返回root
        if (root==p ||root==q)
        {
            return root;
        }
        //左右节点
        TreeNode left=lowestCommonAncestor(root.left,p,q);//左右节点等于搜索到的数值
        TreeNode right=lowestCommonAncestor(root.right,p,q);//搜索到则返回的是p或者q，没搜索到则返回null
        //考虑四种情况
        if (left==null && right==null)
        {
            return null;
        }
        if (left==null &&right!=null)
        {
            return right;
        }
        if(right==null &&left!=null)
        {
            return left;
        }
        if (right!=null && left!=null)
        {
            return root;
        }
        return root;


    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q)
    {

        //记录遍历到的每个节点的父节点。
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        parent.put(root, null);//根节点没有父节点，所以为空
        queue.add(root);

        //存储节点和他的父节点
        while(!parent.containsKey(p) || !parent.containsKey(q))//一直搜索到map包含pq
        {
            TreeNode node=queue.poll();
            //搜索左边
            if (node.left!=null)
            {
                parent.put(node.left,node);
                queue.add(node.left);//入栈是为了更好的提取元素
            }
            if (node.right!=null)
            {
                parent.put(node.right,node);//记录父节点
                queue.add(node.right);//
            }
        }

        //利用set存储包含p节点的父节点
        Set<TreeNode> ans=new HashSet<>();
        while (p!=null)
        {
            ans.add(p);//自己也是自己的祖先
            p=parent.get(p);
        }
        //查看p的祖先里面和q的共同节点
        while (!ans.contains(q))
        {
            q=parent.get(q);
        }
        return q;


    }

    //记录遍历到的每个节点的父节点。
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q)
    {
        parent.put(root, null);//根节点没有父节点，所以为空

        //存储节点和他的父节点

        searchTree(root,p,q);

        //利用set存储包含p节点的父节点
        Set<TreeNode> ans=new HashSet<>();
        while (p!=null)
        {
            ans.add(p);//自己也是自己的祖先
            p=parent.get(p);
        }
        //查看p的祖先里面和q的共同节点
        while (!ans.contains(q))
        {
            q=parent.get(q);
        }
        return q;


    }
    //寻找树
    public void searchTree(TreeNode root,TreeNode p,TreeNode q)
    {

        if (parent.containsKey(p)&&parent.containsKey(q))
        {
            return;
        }else
        {
            if (root.left!=null)
            {
                parent.put(root.left,root);
                searchTree(root.left,p,q);
            }
            if (root.right!=null)
            {
                parent.put(root.right,root);
                searchTree(root.right,p,q);
            }
        }

    }
}
