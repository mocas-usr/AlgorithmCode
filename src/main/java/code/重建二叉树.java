package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/4 上午10:58
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-04 10:58
 */
public class 重建二叉树 {
    //递归构建
    Map<Integer,Integer> map=new HashMap<>();//存储中序遍历的顺序
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder==null)
        {
            return null;
        }
        //把中序顺序存起来
        for (int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);//位置
        }
        TreeNode root=buildMyTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return root;

    }

    public TreeNode buildMyTree(int[] preorder,int pstart,int pend,int[] inorder,int instart,int inend)
    {
        //停止条件
        if (preorder==null)
        {
            return null;
        }
        if (pstart>pend)
        {
            return null;
        }
        int rootVal=preorder[pstart];
        int key=map.get(rootVal);//root在中序 的位置，则左子树在key位置
        int len=key-instart;//左子树长度

        TreeNode root=new TreeNode(rootVal);//root根节点是前序遍历第一个
        root.left=buildMyTree(preorder,pstart+1,pstart+len,inorder,instart,key-1);
        root.right=buildMyTree(preorder,pstart+len+1,pend,inorder,key+1,pend);
        return root;
    }

    public class TreeNode {
        int val;
       TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
  }

}
