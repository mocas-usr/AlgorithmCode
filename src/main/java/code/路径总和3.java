package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/11 下午7:07
 * @email: wangyuhang_mocas@163.com
 */

import java.util.HashMap;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-11 19:07
 */
public class 路径总和3 {

    HashMap<Integer, Integer> map = new HashMap<>();
    int target;

    public int pathSum(TreeNode root, int targetSum) {
        target = targetSum;
        //和为0的数有1个
        map.put(0, 1);

        int ans = dfs(root, 0);
        return ans;
    }

    public int dfs(TreeNode root, int curSum) {
        //终止条件
        if (root == null) {
            return 0;
        }
        int res = 0;
        //截止到目前节点的当前和
        curSum += root.val;

        //当前选择
        //以当前节点为终止节点
        res += map.getOrDefault(curSum - target, 0);
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        //下一路径
        int left = dfs(root.left, curSum);
        int right = dfs(root.right, curSum);
        res = res + left + right;
        //恢复现场
        map.put(curSum,map.getOrDefault(curSum, 0)-1);
        return res;
    }
}
