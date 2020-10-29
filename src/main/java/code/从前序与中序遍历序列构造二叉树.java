package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/26 上午9:31
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-26 09:31
 */
public class 从前序与中序遍历序列构造二叉树 {
    //递归的方式
    Map<Integer,Integer> map=new HashMap<>();//用于记录root的位置
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n=preorder.length;
        for (int i=0;i<n;i++)
        {
            map.put(inorder[i],i);//记录中序遍历值的位置
        }
        //注意，这里的length指的是索引值，但是不包括右边索引
        return buildMyTree(preorder,0,preorder.length,inorder,0,inorder.length);

    }
    //递归搜索
    public  TreeNode  buildMyTree(int[] preorder,int p_start,int p_end,int[] inorder,int in_satrt,int in_end)
    {
        if (p_start>=p_end)
        {
            return null;
        }
        //求出root,前序遍历的首个数就是root
        int rootVal=preorder[p_start];
        int rootIndex=map.get(rootVal);//在中序遍历中的索引
        TreeNode root=new TreeNode(rootVal);//根节点

        int leftNum=rootIndex-in_satrt;//左子树的个数
        int rightNum=p_end-rootIndex-1;//右子树的个数

        //搜寻左边子树,左开右闭区间
        root.left=buildMyTree(preorder,p_start+1,p_start+leftNum+1,inorder,in_satrt,rootIndex);
        //搜寻右子树
        root.right=buildMyTree(preorder,p_start+leftNum+1,p_end,inorder,rootIndex+1,in_end);

        return root;
    }

    @Test
    public void test()
    {
        int[] preorder = {3,9,20,15,7};
        int[] inorder ={9,3,15,20,7};
        buildTree(preorder,inorder);
    }

}
