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
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {

        //计数数组
        int[] count = new int[1001];
        //先统计需要排序的数组
        for (int arr : arr1) {
            count[arr]++;
        }

        //再按顺序排列
        int i = 0;
        for (int num : arr2) {
            while (count[num] > 0) {
                arr1[i] = num;
                count[num]--;
                i++;
            }
        }
        //再排剩下的
        for (int j = 0; j < count.length; j++) {
            while (count[j] > 0) {
                arr1[i] = j;
                i++;
                count[j]--;
            }

        }
        return arr1;

    }

    //shell排序
    Map<Integer, Integer> map = new HashMap<>();

    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        //构建顺序
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        shellSort(arr1);
        return arr1;

    }

    public void shellSort(int[] nums) {

        int len = nums.length;

        for (int gap = len / 2; gap>0; gap /= 2) {
            //插入排序
            insertSort(nums, gap);
        }

    }

    public void insertSort(int[] nums, int gap) {

        //外层控制步长
        for (int i = gap; i < nums.length; i++) {
            //内层控制排序的
            int j=i-gap;
            int temp=nums[i];
            while (j>=0 &&compareNum(temp,nums[j])<=0)
            {
                nums[j+gap]=nums[j];
                j=j-gap;
            }
            //结束时交换位置
            nums[j+gap]=temp;
        }
    }



    public int compareNum(int num1, int num2) {
        if (map.containsKey(num1) && map.containsKey(num2)) {
            return map.get(num1) - map.get(num2);
        } else if (map.containsKey(num1)) {
            return -1;
        } else if (map.containsKey(num2)) {
            return 1;
        } else {
            return num1 - num2;
        }

    }

    @Test
    public void test() {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        relativeSortArray(arr1, arr2);
    }
}
