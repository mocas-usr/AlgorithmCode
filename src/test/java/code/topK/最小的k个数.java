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
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        quickSort(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public void quickSort(int[] arr, int left, int right, int k) {
        if (left > right) {
            return;
        }

        int stand = partion(arr, left, right);
        if (stand > k) {
            quickSort(arr, left, stand-1, k);
        } else if (stand < k) {
            quickSort(arr, stand + 1, right, k);
        } else {
            return;
        }

    }

    public int partion(int[] nums, int left, int right) {

        int index = left;
        int target = nums[left];

        while (left < right) {

            while (left < right && nums[right] >= target) {
                right--;
            }
            while (left < right && nums[left] <= target) {
                left++;
            }
            if (left < right) {
                swap(nums,left,right);
            }
        }
        //
        swap(nums,index,left);
        return left;

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
