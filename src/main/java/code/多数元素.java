package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/17 21:32
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-17 21:32
 */
public class 多数元素 {

    //投票法
    public int majorityElement(int[] nums) {

        int votes=0;
        int num=nums[0];
        for (int i=0;i<nums.length;i++)
        {
            if (votes==0)
            {
                num=nums[i];
                votes++;
            }else
            {
                if (nums[i]!=num)
                {
                    votes--;

                }else
                {
                    votes++;
                }
            }

        }
        return num;

    }

    @Test
    public void test()
    {
        int[] nums={3,2,3};
        int res=majorityElement(nums);
        System.out.println(res);
    }
}
