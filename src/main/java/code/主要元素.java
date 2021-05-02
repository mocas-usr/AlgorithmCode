package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/1 下午5:23
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-01 17:23
 */
public class 主要元素 {

    public int majorityElement(int[] nums) {

        int vote=0;
        int maxNum=nums[0];
        for (int num : nums) {
            if (vote==0)
            {
                maxNum=num;
                vote++;
            }else
            {
                if (num!=maxNum)
                {
                    vote--;
                }else
                {
                    vote++;
                }
            }

        }

        //出现频率最高的数
        int count=0;
        for (int num:nums)
        {
            if (num==maxNum)
            {
                count++;
            }
        }
        if (count>nums.length/2)
        {
            return maxNum;
        }else
        {
            return -1;
        }

    }

    @Test
    public void test()
    {
       int[] nums={1,2,5,9,5,9,5,5,5};
        int res=majorityElement(nums);
        System.out.println(res);
    }
}
