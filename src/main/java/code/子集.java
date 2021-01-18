package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/11 19:31
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-11 19:31
 */
public class 子集 {
    //回溯
    //全局变量
    List<List<Integer>> res=new LinkedList<>();//结果
    //恢复变量
    List<Integer> list=new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {

        if (nums.length==0)
        {
            return new LinkedList<>();
        }
        res.add(new LinkedList<>());
        //起始搜索路径
        dfs(0,nums);
        return res;


    }

    public void dfs(int index,int[] nums)
    {
        //终止条件
        if (index==nums.length)
        {
            return;
        }

        //剪枝

        //for 选择列表

        for (int i=index;i<nums.length;i++)
        {
            //做选择
            if (list.contains(nums[i]))
            {
                continue;
            }
            list.add(nums[i]);
            if (!res.contains(list))
            {
                res.add(new LinkedList<>(list));
            }

            //下一路径
            dfs(i+1,nums);
            //恢复现场
            list.remove(list.size()-1);

        }
    }

    @Test
    public void test()
    {
        int[] nums={1,2,3};
        subsets(nums);
        System.out.println(1);
    }
}
