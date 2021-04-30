package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/22 下午5:15
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-22 17:15
 */
public class 整数转换 {
    public int convertInteger(int A, int B) {

        int sum = 0;
        sum = A ^ B;
        int res = 0;
        while (sum != 0) {
            sum &= (sum - 1);
            res++;
        }
        return res;

    }
}
