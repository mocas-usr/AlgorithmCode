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


    public int cuttingRope(int n) {

        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        int m = n / 3 - 1;
        int yu = n % 3;

        long res = 1;
        //先求3的m次方
        long x = 3;
        int p = 1000000007;

        while (m > 0) {
            if ((m & 1) == 1) {
                res = res * x % p;
            }
            x = x * x%p;
            m >>= 1;
        }


        if (yu == 2) {
            //剩余长度是5
            res = res * 3 * 2 % p;
        } else if (yu == 1) {
            res = res * 4 % p;
        } else {
            res = res * 3 % p;
        }
        return (int) res;

    }
}
