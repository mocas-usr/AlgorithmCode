package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/10 下午8:35
 * @email: wangyuhang_mocas@163.com
 */

import java.util.*;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-10 20:35
 */
public class 最接近的三数之和 {
    //三指针
    public int threeSumClosest(int[] nums, int target) {


        Arrays.sort(nums);

        Map<Integer, Integer> listMap = new HashMap<>();
        int delta = Integer.MAX_VALUE;
        //最左边的指针为基准
        int n = nums.length;
        for (int i = 0; i < nums.length - 2; i++) {

            int num1 = nums[i];
            //初始化
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = num1 + nums[left] + nums[right];
                int temp=sum-target;
                if (Math.abs(temp)<Math.abs(delta))
                {
                    delta=temp;
                }
                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    return sum;
                }

            }
        }

        return target+delta;

    }
}
