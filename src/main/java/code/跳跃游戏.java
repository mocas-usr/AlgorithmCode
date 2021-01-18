package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/8 20:46
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-08 20:46
 */
public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        if(nums.length==0)
        {
            return false;
        }

        int res=0;
        //不停更新最远处
        for (int i=0;i<nums.length;i++)
        {
            //这个时候有可能res会更新
            if (res>=i)
            {
                res=Math.max(res,i+nums[i]);
            }else //这个时候
            {

            }
            if (res>=nums.length-1)
            {
                return true;
            }

        }

        return false;

    }

    @Test
    public void test()
    {
        int[] nums={2,3,1,1,4};
        boolean e=canJump(nums);
        System.out.println(e);

    }
}
