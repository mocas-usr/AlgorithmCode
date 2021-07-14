package code.位运算;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/14 上午10:00
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-14 10:00
 */
public class 加一 {

    public int[] plusOne(int[] digits) {

        int n=digits.length;
        int[] res=new int[n+1];
        int num=1;
        int temp=0;
        for (int i=n-1;i>=0;i--)
        {
            temp=digits[i]+num;
            digits[i]=temp%10;
            num=temp/10;
            res[i+1]= digits[i];
            if (num==0)
            {
                return digits;
            }
        }
        if (num==1)
        {
            res[0]=1;
            return res;
        }else
        {
            return digits;
        }

    }

    @Test
    public void test() {
        int[] digits = {9};
        int[] result = plusOne(digits);
        System.out.println(result);
    }
}
