package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/29 下午7:24
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-29 19:24
 */
public class 搜索旋转数组 {

    //方法1 判断mid和right位置
    public int search(int[] arr, int target) {

        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        //去重
        while (left < right && arr[left] == arr[right]) {
            left++;
        }
        //寻找转折元素
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else if (arr[mid] < arr[right]) {
                right = mid;
            } else {
                right--;

            }


        }

        if (left == 0) {
            right = arr.length - 1;
        }
        if (target == arr[0]) {
            return 0;
        } else if (target > arr[0]) {
            left = 1;
        } else {
            right = arr.length - 1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (arr[left] == target) {
            return left;
        } else {
            return -1;
        }
    }

    @Test
    public void test()
    {
        int[] arr = {-1, -2};
        int target = 899148371;
        int res=search(arr,target);
        System.out.println(res);
    }
}
