package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/25 下午7:46
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-25 19:46
 */
public class 组合 {
    int[] nums;
    List<List<Integer>> res = new LinkedList<>();
    List<Integer> list=new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        //1--n个数
        nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }

        dfs(0,k);
        return res;


    }


    public void dfs(int index,int k) {

        //终止条件
        if (list.size()==k)
        {
            res.add(new LinkedList<>(list));
            return;
        }
        if (index==nums.length)
        {
            return;
        }
        //for 循环列表
        for (int i=index;i<nums.length;i++)
        {
            // 当前选择
            list.add(nums[i]);
            // 下一路径
            dfs(i+1,k);
            // 恢复现场
            list.remove(list.size()-1);
        }
    }

    @Test
    public void test()
    {
        List<List<Integer>>res= combine(4, 2);
        System.out.println(res);
    }
}
