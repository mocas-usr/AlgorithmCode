package code.位运算;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/14 上午11:25
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-14 11:25
 */
public class 数组中数字出现的次数2 {

    public int singleNumber(int[] nums) {

        int[] count=new int[32];
        //统计所有位的个数
        for (int num:nums)
        {
            for (int i=0;i<32;i++)
            {
                int t=num&1;
                count[i]+=t;
                num>>=1;
            }
        }

        int res=0;
        for (int i=0;i<32;i++)
        {
            res<<=1;
            int bit=count[31-i]%3;
            res|=bit;

        }
        return res;


    }

    @Test
    public void test()
    {
        int[] nums={3,4,3,3};
        int res=singleNumber(nums);
        System.out.println(res);
    }
}
