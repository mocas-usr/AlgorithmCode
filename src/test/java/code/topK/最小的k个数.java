package code.topK;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/25 上午10:45
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-25 10:45
 */
//实践各种排序算法
public class 最小的k个数 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length < k)
            return new int[0];
        quickSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);
    }

    public void quickSort(int[] nums, int left, int right, int k) {
        if (left > right) {
            return;
        }
        int stand = partion(nums, left, right, k);
        if (stand == k) {
            return;
        } else if (stand > k) {
            quickSort(nums, left, stand - 1, k);
        } else {
            quickSort(nums, stand + 1, right, k);
        }
    }

    public int partion(int[] nums, int left, int right, int k) {
        int one = left;
        int temp = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= temp) {
                right--;

            }
            while (left < right && nums[left] <= temp) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        swap(nums, left, one);
        return left;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
