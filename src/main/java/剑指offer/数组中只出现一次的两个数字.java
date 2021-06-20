package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/16 下午9:26
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-16 21:26
 */
public class 数组中只出现一次的两个数字 {

    public int[] FindNumsAppearOnce(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum ^= num;
        }
        //sum 是x异或y 的数值
        int x = 1;
        while (sum != 0) {
            if ((sum & x) != 0) {
                break;
            }
            x <<= 1;
        }
        int ans1 = 0;
        int ans2 = 0;
        for (int num : array) {
            if ((num & x) == 0) {
                ans1 ^= num;
            } else {
                ans2 ^= num;
            }
        }
        if (ans1 > ans2) {
            int temp = ans1;
            ans1 = ans2;
            ans2 = temp;
        }
        return new int[]{ans1, ans2};
        // write code here
    }
}
