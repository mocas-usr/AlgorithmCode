package code.位运算;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/12 下午2:52
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-12 14:52
 */
public class 数组中数字出现的次数 {

    //位运算
    public int[] singleNumbers(int[] nums) {
        //先异或所有
        int total=0;//0异或所有的数值没有关系
        for (int num:nums)
        {
            total^=num;
        }

        //寻找分辨两个不同数值的位
        int div=1;
        //异或是相同为0.不同为1
        //则div&1==1时，div为分辨两个数的值
        while ((div&total)==0)
        {
            div<<=1;//左移
        }

        //div来分辨两个数
        int num1=0;
        int num2=0;
        for (int num:nums)
        {
            //分组,div只有一位是1
            if ((num&div)==0)
            {
                num1^=num;
            }else
            {
                num2^=num;
            }
        }
        return new int[]{num1,num2};
    }

    @Test
    public void test()
    {
        int[] nums={6,2,3,3};
        int[] res=singleNumbers(nums);
        System.out.println(res);
    }
}
