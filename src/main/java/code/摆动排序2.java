package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/13 下午3:51
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-13 15:51
 */
public class 摆动排序2 {
    public void wiggleSort(int[] nums) {

        if (nums.length == 0) {
            return;
        }

        int[] help = nums.clone();
        Arrays.sort(help);
        int N = nums.length-1;
        for (int i = 1; i < help.length; i += 2) {
            nums[i] = help[N--];
        }
        //插入
        for (int i = 0; i < help.length; i += 2) {
            nums[i] = help[N--];
        }

    }

    @Test
    public void test() {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        System.out.println(nums);
    }
}
