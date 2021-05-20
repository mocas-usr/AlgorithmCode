package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/20 下午8:09
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-20 20:09
 */
public class 完全平方数 {

    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        int left = 2;
        int right = num / 2;
        int guass=0;

        while (left < right) {
            int mid = left + (right - left) / 2;
            guass=mid*mid;
            if (guass<num)
            {
                left=left+1;
            }
            if (guass>num)
            {
                right=right-1;
            }
            if (guass==num)
            {
                return true;
            }
        }
        return false;
    }
}
