package code.递归;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/24 下午10:09
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-24 22:09
 */
public class 组合总和2 {

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if (candidates.length == 0) {
            return new LinkedList<>();

        }

        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);

        return res;

    }

    public void dfs(int[] nums, int target, int index, int sum) {
        //终止条件
        if (index == nums.length) {
            return;
        }
        if (sum > target) {
            return;
        }

        //for 循环选择
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            //当前选择
            list.add(nums[i]);
            sum+=nums[i];
            if (sum==target)
            {
                res.add(new LinkedList<>(list));
            }
            dfs(nums,target,i+1,sum);
            //恢复现场
            sum-=nums[i];
            list.remove(list.size()-1);

        }
    }
}
