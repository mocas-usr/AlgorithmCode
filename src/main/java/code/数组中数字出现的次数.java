package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/12 下午2:31
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-12 14:31
 */
public class 数组中数字出现的次数 {

    public int[] singleNumbers(int[] nums) {

        //全部异或，相同为0，不同为1，则得到结果是两个不同数值异或结果
        int temp=0;
        //x异或0为x
        for (int tmp:nums)
        {
            temp^=tmp;
        }
        //得到两个不同数值异或结果
        //求位为1的数值
        int t=1;
        while ((temp&t)==0)//说明此位为0
        {
            t<<=1;//左移一位
        }

        int a=0;
        int b=0;
        //分两组进行
        for (int num:nums)
        {
            //t是判别依据
            if ((num&t)==0)
            {
                //这一组全部异或的结果就是a
                a^=num;
            }else
            {
                b^=num;
            }

        }
        return new int[]{a,b};

    }
}
