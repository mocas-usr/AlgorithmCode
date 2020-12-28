package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/27 下午7:59
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-27 19:59
 */
public class 三数之和 {
    //排序+双指针
    public List<List<Integer>> threeSum(int[] nums) {

        //先排序
        Arrays.sort(nums);
        int len=nums.length;
        //结果存放
        List<List<Integer>> res=new LinkedList<>();
        for (int i=0;i<len;i++)
        {

            int l=i+1;
            int r=len-1;
            //此时，要去重nums
            if (i>0&&nums[i]==nums[i-1])
            {
                continue;
            }
            //双指针
            while (l<r)
            {

                int sum=nums[i]+nums[l]+nums[r];
                if (sum==0)
                {


                    //添加结果集
                    List<Integer> list=new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    res.add(list);
                    //去重，排除这种情况下重复元素
                    while (l<r&&nums[l]==nums[l+1])
                    {
                        l++;
                    }
                    while (l<r &&nums[r]==nums[r-1])
                    {
                        r--;
                    }
                    r--;
                    l++;

                }else if (sum<0)
                {
                    //这里可以不进行上述的去重，因为本身也不等
                    l++;
                }else if (sum>0)
                {
                    r--;
                }



            }

        }
        return res;
    }

    @Test
    public void test()
    {
        int[] nums={-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res=threeSum(nums);
        System.out.println(res);

    }

}
