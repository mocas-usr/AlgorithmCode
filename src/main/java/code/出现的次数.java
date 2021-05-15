package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/15 上午10:12
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-15 10:12
 */
public class 出现的次数 {

    public int numberOf2sInRange(int n) {

        int bit = 1;
        int high = n / 10;
        int low = 0;
        int cur = n % 10;
        int res = 0;

        //
        while (high != 0 || cur != 0) {

            if (cur == 2) {
                res += high * bit + low + 1;

            } else if (cur > 2) {
                res += (high + 1) * bit;
            } else {
                res += high * bit;
            }
            low += cur * bit;
            cur = high % 10;
            high = high / 10;
            bit *= 10;

        }
        return res;


    }
}
