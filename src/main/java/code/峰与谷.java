package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/30 下午7:14
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-30 19:14
 */
public class 峰与谷 {

    public void wiggleSort(int[] nums) {

        int[] temp = nums.clone();
        int N = nums.length - 1;
        Arrays.sort(temp);
        //先排序最大的
        for (int i = 0; i < nums.length; i += 2) {
            nums[i] = temp[N--];
        }
        //再排序小的

        for (int i = 1; i < nums.length; i += 2) {
            nums[i]=temp[N--];
        }

    }
}
