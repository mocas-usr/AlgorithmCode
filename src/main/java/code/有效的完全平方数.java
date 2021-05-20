package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/19 下午8:08
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-19 20:08
 */
public class 有效的完全平方数 {

    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        long left = 2;
        long right = num / 2;
        long guass = 0;
        long mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            guass = mid * mid;
            if (guass < num) {
                left = mid + 1;
            }
            if (guass > num) {
                right = mid - 1;
            }
            if (guass == num) {
                return true;
            }
        }
        return false;
    }
}
