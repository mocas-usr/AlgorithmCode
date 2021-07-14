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
    //全局变量
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates.length == 0) {
            return new LinkedList<>();
        }
        int sum = 0;
        dfs(candidates, 0, target, sum);

        return res;
    }

    public void dfs(int[] cand, int index, int target, int sum) {
        //终止条件
        if (index==cand.length)
        {
            return;
        }
        if (sum>=target)
        {
            return;
        }

        //for 循环列表
        for (int i=index;i<cand.length;i++)
        {
            //当前选择
            list.add(cand[i]);
            sum+=cand[i];
            if (sum==target)
            {
                res.add(new LinkedList<>(list));
                //恢复现场
            }
            //下一路径
            dfs(cand,index,target,sum);
            //恢复现场
            sum-=cand[i];
            list.remove(list.size()-1);
        }
    }

    @Test
    public void test() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = combinationSum(candidates, target);
        System.out.println(res);
    }
}
