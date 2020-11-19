package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/14 下午2:44
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-14 14:44
 */
public class 二叉搜索树的第k大节点 {
    //中序遍历是有序的
    public int kthLargest(TreeNode root, int k) {

        List<Integer> list=new LinkedList<>();//记录所有的数据点
        searchTree(root,list);
        int res=list.get(k-1);
        return res;
    }

    //中序遍历
    public void searchTree(TreeNode root,List<Integer> list)
    {
        if (root==null)
        {
            return;
        }
        searchTree(root.right,list);
        if (root!=null)
        {
            list.add(root.val);
        }
        searchTree(root.left,list);
    }
}
