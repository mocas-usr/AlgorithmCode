package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/22 下午3:17
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-22 15:17
 */
public class 幂集 {
    List<List<Integer>> res;
    List<Integer> list;

    public List<List<Integer>> subsets(int[] nums) {
        res = new LinkedList<>();
        list = new LinkedList<>();

        dfs(nums,0);
        return res;


    }

    public void dfs(int[] nums,int index) {
        //终止条件
        res.add(new LinkedList<>(list));

        //for 循环列表
        for (int i=index;i<nums.length;i++)
        {
            // 当前选择
            list.add(nums[i]);
            // 下一路径
            dfs(nums,i+1);
            // 恢复现场
            list.remove(list.size()-1);

            }




    }

    public List<List<Integer>> subsets2(int[] nums)
    {
        List<List<Integer>> res=new LinkedList<>();

        //先添加空集合
        res.add(new LinkedList<>());
        for (int num:nums)
        {

            int size=res.size();
            for (int i=0;i<size;i++)
            {
                List<Integer> list=new LinkedList<>(res.get(i));
                list.add(num);
                res.add(list);

            }
        }
        return res;


    }
    @Test
    public void test()
    {
        int[] nums={1,2,3};
        List<List<Integer>> res=subsets( nums);
        System.out.println(res);
    }
}

