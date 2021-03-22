package code.位运算;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/14 上午10:00
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-14 10:00
 */
public class 加一 {

    public int[] plusOne(int[] digits) {

        int len=digits.length;
        int[] result=new int[len+1];
        int plus=1;
        for (int i=len-1;i>=0;i--)
        {
            int num=digits[i]+plus;
            plus=num/10;
            digits[i]=num%10;

            result[i+1]=digits[i];

            if (plus==0){
                return digits;
            }
        }
        if (plus==1)
        {
            result[0]=1;
            return result;

        }else
        {
            return digits;
        }

    }
    @Test
    public void test()
    {
        int[] digits={9,9,9};
        int[] result=plusOne(digits);
        System.out.println(result);
    }
}
