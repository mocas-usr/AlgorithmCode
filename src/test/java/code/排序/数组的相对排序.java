package code.排序;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/5 下午6:19
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-05 18:19
 */
public class 数组的相对排序 {
    //计数排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        //arr1和arr2的长度有限
        int[] nums = new int[10001];
        //计数
        for (int arr : arr1) {
            nums[arr]++;
        }

        int i = 0;
        //先排arr2的数值
        for (int arr : arr2) {
            while (nums[arr] > 0) {
                arr1[i++] = arr;
                nums[arr]--;
            }
        }
        //再排arr1剩余的
        for (int j = 0; j < nums.length; j++) {

            while (nums[j] > 0) {
                arr1[i++] = j;
                nums[j]--;
            }
        }
        return arr1;
    }

    @Test
    public void test() {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        relativeSortArray(arr1, arr2);
    }
}
