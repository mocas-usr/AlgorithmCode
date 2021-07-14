package code.数字问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/9 上午10:22
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-12-09 10:22
 */
public class 数字序列中某一位的数字 {

    public int findNthDigit(int n) {

        //当前位数下的个数
        long count=9;//多少位数
        long start=1;//当前位起始数值
        long bit=1;//几位数
        //先求所在数字
        while (n>count)
        {
            n-=count;
            bit++;
            start*=10;
            count=bit*start*9;
        }
        //当前所在数值
        long num=start+(n-1)/bit;//保证所在（n-1）
        char ch=String.valueOf(num).charAt((int) ((n-1)%bit));
        return ch-'0';
    }
}
