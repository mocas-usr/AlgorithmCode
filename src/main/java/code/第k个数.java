package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/2 下午8:20
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-02 20:20
 */
public class 第k个数 {

    public int getKthMagicNumber(int k) {

        int a3 = 0;
        int a5 = 0;
        int a7 = 0;
        int[] nums = new int[k];
        nums[0] = 1;
        for (int i = 1; i < k; i++) {
            //最大值
            nums[i] = Math.min(nums[a3] * 3, Math.min(nums[a5] * 5, nums[a7] * 7));
            if (nums[i] == nums[a3] * 3) {
                a3++;
            }
            if (nums[i] == nums[a5] * 5) {
                a5++;
            }
            if (nums[i] == nums[a7] * 7) {
                a7++;
            }


        }
        return nums[k - 1];

    }

    @Test
    public void test() {
        int res = getKthMagicNumber(7);
        System.out.println(res);
    }
}
