package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/19 下午2:43
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-19 14:43
 */
/*数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。



        你可以假设数组是非空的，并且给定的数组总是存在多数元素。*/
public class 数组中出现次数超过一半的数字 {
    //排序法，先排序，中间的就是符合要求的
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);//从小到大
        int n = nums.length;
        int result = nums[n / 2];
        return result;

    }

    //记录数字的次数
    public int majorityElement2(int[] nums) {
        //记录数字次数
        HashMap<Integer, Integer> map = new HashMap<>();

        //
        for (int num : nums) {
            //如果包含，则数量加1
            if (map.containsKey(num)) {
                map.put(num, map.getOrDefault(num, 1) + 1);

            } else {
                //不包含，则赋值为0
                map.put(num, 1);
            }
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;


    }


    //摩尔投票法
    public int majorityElement3(int[] nums) {
        int votes = 0;
        int num = 0;

        //遍历
        for (int i = 0; i < nums.length; i++) {
            //如果投票数为0，则新的假设结果为nums[i]
            if (votes == 0) {
                num = nums[i];
            } else {

            }
            if (nums[i] != num) {
                votes--;//计数
            } else {
                votes++;
            }

        }
        return num;


    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int re = majorityElement3(nums);
    }
}
