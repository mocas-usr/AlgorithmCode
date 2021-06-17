package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/16 下午6:59
 * @email: wangyuhang_mocas@163.com
 */

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-16 18:59
 */
public class 最小的K个数 {
    ArrayList<Integer> res=new ArrayList<>();
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        if (k>input.length)
        {
            return new ArrayList<>();
        }
        quickSort(input, 0, input.length - 1, k);
        for (int i=0;i<k;i++)
        {
            res.add(input[i]);
        }
        return res;
    }

    public void quickSort(int[] nums, int left, int right, int k) {
        if (left > right) {
            return;
        }
        int stand = partion(nums, left, right);
        if (k < stand) {
            quickSort(nums, left, stand - 1, k);
        } else if (k > stand) {
            quickSort(nums, stand + 1, right, k);

        } else {
            return;
        }
    }

    //寻找位置
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
                swap(nums, left, right);
            }
        }
        //left==right
        swap(nums, left, index);
        return left;

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
