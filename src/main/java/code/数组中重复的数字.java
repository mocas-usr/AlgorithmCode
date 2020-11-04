package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/2 下午5:06
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-02 17:06
 */
public class 数组中重复的数字 {

    //通过计数排序方式，时间o(n)，空间o（n）
    public int findRepeatNumber(int[] nums) {
        if (nums.length==0)
        {
            return 0;
        }
        int n=nums.length;
        int[] count=new int[n];

        //count[2]=3说明等于2的数值有3个
        for (int temp:nums)
        {
            count[temp]++;
            if (count[temp]>1)
            {
                return temp;
            }
        }
        return 0;


    }
    @Test
    public void test()
    {
        int[] nums={2, 3, 1, 0, 2, 5, 3};
        findRepeatNumber(nums);
    }
}
