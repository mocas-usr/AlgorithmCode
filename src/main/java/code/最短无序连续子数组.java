package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/17 下午6:20
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-17 18:20
 */
public class 最短无序连续子数组 {
    //暴力解法
    public int findUnsortedSubarray(int[] nums) {
        int right=0;
        int left=nums.length;
        //遍历
        for (int i=0;i<nums.length-1;i++)
            for (int j=i+1;j<nums.length;j++)
            {
                //说明这个位置开始出现错误元素
                if (nums[i]>nums[j])
                {
                    left=Math.min(left,i);
                    right=Math.max(right,j);
                }
            }
        if (right-left<0)
        {
            return 0;
        }else
        {
            return right-left+1;
        }
    }

    //遍历
    public int findUnsortedSubarray2(int[] nums)
    {
        int len=nums.length;
        int max=nums[0];
        int min=nums[len-1];
        int end=-1;
        int begin=0;
        //遍历
        //从左到右
        for (int i=0;i<len;i++)
        {
            //如果大于max，则更新max，如果后面是有序的，则一直更新max
            if (nums[i]>=max)
            {
                max=nums[i];
            }else if (nums[i]<max)
            {
                end=i;//代表最后一个小于max的值
            }

            if(nums[len-i-1] > min){    //从右到左维持最小值，寻找左边界begin
                begin = len-i-1;
            }else{
                min = nums[len-i-1];
            }



        }

        return end-begin+1;
    }

    @Test
    public void test()
    {
        int[] nums={2, 6, 4, 8, 10, 9, 15};
        findUnsortedSubarray(nums);
    }
}
