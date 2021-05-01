package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/10 上午11:34
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-10 11:34
 */
public class 整数反转 {

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = x % 10;

            if (res > 0 && (Integer.MAX_VALUE - temp) / 10 < res)
                return 0;
            if (res < 0 && (Integer.MIN_VALUE - temp) / 10 > res)
                return 0;
            res = res * 10 + temp;
            x /= 10;
        }
        return res;
    }

    @Test
    public void test() {
        int x = -123;
        int res = reverse(x);
        System.out.println(res);
    }
}
