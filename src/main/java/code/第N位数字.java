package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/11 下午7:42
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-11 19:42
 */
public class 第N位数字 {
    public int findNthDigit(int n) {

        //个位开始初始化
        int digit = 1;//代表几位数
        long start = 1;//代表这个位数的起始值，比如起始是1，，10 ，100
        long count = 9;//个位有9个数

        //查找n所在的数
        //大于剩余的位数时
        while (n > count) {
            //说明比count位数多
            n -= count;//剩余的位数
            digit = digit + 1;//位数+1
            start = start * 10;
            ;
            count = 9 * start * digit;//总共多少位
        }

        //跳出循环
        long num = start + (n - 1) / digit;
        int temp = Long.toString(num).charAt((n - 1) % digit) - '0';

        return temp;

    }
}
