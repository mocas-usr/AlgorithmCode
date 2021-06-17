package code.排序;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/5 下午6:12
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-05 18:12
 */
public class 最小的k个数 {
    //
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length < k) {
            return new int[0];
        }
        //默认小顶堆，即头部最小，
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> (v2 - v1));

        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else {
                if (num < queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        int[] res = new int[k];
        int key = 0;
        while (key < k && !queue.isEmpty()) {
            res[key++] = queue.poll();
        }
        return res;

    }

    @Test
    public void test() {
        int[] nums = {3, 2, 1, 0, 0, 4};
        int[] res = getLeastNumbers(nums, 2);
        System.out.println(res);
    }

    //快速排序
    public int[] getLeastNumbers2(int[] arr, int k) {

        int[] res = new int[k];
        quickSort(arr, 0, arr.length - 1, k);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;

    }

    public void quickSort(int[] nums, int left, int right, int k) {
        if (left > right) {
            return;
        }
        int stand = partion(nums, left, right, k);
        if (stand == k) {
            return;
        } else if (stand > k) {
            quickSort(nums, 0, stand - 1, k);

        } else {
            quickSort(nums, stand + 1, right, k);
        }

    }

    public int partion(int[] nums, int left, int right, int k) {
        int t = left;
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
        //l=r
        swap(nums, left, t);
        return left;

    }


    //交换
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
