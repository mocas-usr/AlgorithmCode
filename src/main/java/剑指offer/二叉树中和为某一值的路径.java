package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 下午8:25
 * @email: wangyuhang_mocas@163.com
 */

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 20:25
 */
public class 二叉树中和为某一值的路径 {
    //全局变量
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null) {
            return new ArrayList<>();
        }
        int sum = 0;
        dfs(root, target, sum);
        return res;

    }

    public void dfs(TreeNode root, int target, int sum) {
        //终止条件
        if (root==null)
        {
                return;
        }
        //剪枝
        //当前选择
        sum+=root.val;
        list.add(root.val);
        if (sum==target &&root.left==null &&root.right==null)
        {
            res.add(new ArrayList<>(list));
        }
        //下一路径
        dfs(root.left,target,sum);
        dfs(root.right,target,sum);
        sum-=root.val;
        list.remove(list.size()-1);
    }
}
