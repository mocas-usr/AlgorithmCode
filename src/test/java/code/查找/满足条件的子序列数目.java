package code.查找;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/13 下午8:48
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-13 20:48
 */
public class 满足条件的子序列数目 {
    private static final long MOD = 1000000007;
    public int numSubseq(int[] nums, int target) {

        long ans = 0;
        Arrays.sort(nums);
        long[] rs = new long[nums.length];
        rs[0] = 1;
        for (int i = 1; i < nums.length; ++i) {
            rs[i] = (rs[i - 1] << 1) % MOD;
        }


        int n = nums.length;
        for (int i = 0; i < nums.length; i++) {

            int min = nums[i];
            int left = i ;
            int right = n - 1;


            //标志数据,二分逼近
            int res = -1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (min + nums[mid] < target) {
                    res=mid;
                    left = mid + 1;

                } else if (nums[mid] + min > target) {
                    right = mid - 1;

                } else {
                    res = mid;
                    left = mid + 1;
                }
            }
            //对应是i,res
            if (res>=i&&nums[res] + nums[i] <= target) {
                ans = (ans + rs[res - i]) % MOD;
            }
        }
        return (int) ans;
    }
}
