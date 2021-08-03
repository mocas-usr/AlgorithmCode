package code.递归;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/7 21:35
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-01-07 21:35
 */
public class 组合总数 {

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates.length == 0) {
            return new LinkedList<>();
        }

        //起点
        dfs(candidates, target, 0, 0);
        return res;
    }

    public void dfs(int[] nums, int target, int index, int sum) {

        //终止条件
        if (index == nums.length) {
            return;
        }
        //剪枝
        if (sum>target)
        {
            return;
        }
        //当前操作

        //for循环列表

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            sum += nums[i];
            if (sum == target) {

                res.add(new LinkedList<>(list));
            }
            dfs(nums, target, i, sum);
            //恢复现场
            sum -= nums[i];
            list.remove(list.size() - 1);
        }

    }

    //0,1背包

    @Test
    public void test() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates, target);
        System.out.println(res);
    }
}
