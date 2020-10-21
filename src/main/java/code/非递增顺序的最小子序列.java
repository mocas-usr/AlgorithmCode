package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/18 上午11:25
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-18 11:25
 */
/*
给你一个数组 nums，请你从中抽取一个子序列，满足该子序列的元素之和 严格 大于未包含在该子序列中的各元素之和。

        如果存在多个解决方案，只需返回 长度最小 的子序列。如果仍然有多个解决方案，则返回 元素之和最大 的子序列。

        与子数组不同的地方在于，「数组的子序列」不强调元素在原数组中的连续性，也就是说，它可以通过从数组中分离一些（也可能不分离）元素得到。

        注意，题目数据保证满足所有约束条件的解决方案是 唯一 的。同时，返回的答案应当按 非递增顺序 排列。

*/
/*那么每次挑选元素，肯定都要先拿剩下当中最大的（贪心、当前最好的选择、局部最优解）。
        被挑选出去的元素，不影响下次挑选的策略（无后效性）*/
public class 非递增顺序的最小子序列 {
    public List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        //总和
        for (int x : nums) {
            sum = sum + x;
        }
        //排序,从小到大
        Arrays.sort(nums);

        int temp = 0;
        List<Integer> list = new LinkedList<>();
        //a+b+c>c+e+f 2(a+b+c)>sum
        for (int i = nums.length - 1; i >= 0; i--) {
            temp = temp + nums[i];
            list.add(nums[i]);
            if (temp * 2 > sum) {
                break;
            }
        }
        return list;

    }
}
