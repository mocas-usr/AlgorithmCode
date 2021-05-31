package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/24 下午9:31
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-24 21:31
 */
public class 二叉树的所有路径 {

    List<String> res=new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root==null)
        {
            return new LinkedList<>();
        }
        String  path="";
        dfs(root,path);
        return res;
    }

    public void dfs(TreeNode root,String  path)
    {
        //终止条件
        if (root==null)
        {
            return;
        }
        //for 循环列表
        path+=String.valueOf(root.val);
        // 当前选择
        //剪枝
        if (root.left==null && root.right==null)
        {

            res.add(path);
            return;
        }
        // 下一路径
        dfs(root.left,path+"->");
        dfs(root.right,path+"->");
    }

}
