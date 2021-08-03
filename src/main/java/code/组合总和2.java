package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/24 下午8:57
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.*;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-24 20:57
 */
public class 组合总和2 {

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> list = new LinkedList<>();
    boolean[] visit;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return new LinkedList<>();
        }
        Arrays.sort(candidates);
        visit = new boolean[candidates.length];

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
        //for 循环列表
        for (int i = index; i < nums.length; i++) {
            //当前路径
            if (i > index && nums[i] == nums[i - 1] ) {
                continue;
            }
//            visit[i] = true;
            list.add(nums[i]);
            sum += nums[i];
            if (sum == target) {
                res.add(new LinkedList<>(list));
            }
            dfs(nums, target, i + 1, sum);
//            visit[i]=false;
            list.remove(list.size() - 1);
            sum -= nums[i];

        }
    }

    @Test
    public void test() {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = combinationSum2(candidates, target);
        System.out.println(res);
    }
}
