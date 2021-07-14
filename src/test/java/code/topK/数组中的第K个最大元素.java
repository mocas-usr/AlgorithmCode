package code.topK;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/25 上午10:52
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Enumeration;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-25 10:52
 */
public class 数组中的第K个最大元素 {

    //
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return -1;
        }

        quickSort(nums, 0, nums.length - 1, k-1);
        return nums[k-1];
    }

    public void quickSort(int[] nums, int left, int right, int k) {
        if (left > right) {
            return;
        }

        int stand = partion(nums, left, right);
//        quickSort(nums, left, stand-1, k);
//        quickSort(nums, stand + 1, right, k);
        if (stand > k) {
            quickSort(nums, left, stand-1, k);
        } else if (stand < k) {
            quickSort(nums, stand + 1, right, k);
        } else {
            return;
        }
    }

    public int partion(int[] nums, int left, int right) {
        int index = left;
        int target = nums[left];

        while (left < right) {
            while (left < right && nums[right] <= target) {
                right--;
            }
            while (left < right && nums[left] >= target) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        //
        swap(nums, left, index);
        return left;

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test() {
        int[] nums = {-1, 2, 0};
        int res = findKthLargest(nums, 2);
        System.out.println(res);
    }

}
