package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/8 下午3:15
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-08 15:15
 */
public class 两个数组间的距离值 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        int res = 0;
        boolean f = false;
        for (int i = 0; i < arr1.length; i++) {
            f = false;

            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    f = true;
                    break;
                }
            }
            if (!f) {
                res++;
            }
        }
        return res;
    }
}
