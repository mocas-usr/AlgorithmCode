package code.数字问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/14 下午4:15
 * @email: wangyuhang_mocas@163.com
 */

import code.实现strStr;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-14 16:15
 */
public class 剪绳子2 {


    //每段长度为3
    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int num = n / 3 - 1;
        int less = n % 3;

        //求3的num次方
        long res = 1;
        long t = 3;
        int p = 1000000007;
        while (num > 0) {
            //如果是奇数
            if ((num & 1) == 1) {
                res = res * t % p;
            }
            t = t * t % p;
            num >>= 1;
        }

        //剩下的部分进行处理
        if (less == 0) {
            //剩余长度是3
            res = res * 3 % p;
        } else if (less == 1) {
            //剩余长度是4
            res = res * 4 % p;
        } else if (less == 2) {
            res = res * 3 * 2 % p;
        }
        return (int) res;


    }
}
