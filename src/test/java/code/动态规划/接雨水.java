package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/21 下午5:17
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-21 17:17
 */
public class 接雨水 {
    public int trap(int[] height) {

        int n = height.length;
        //leftmax[i]为nums[i]左边的最高
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        for (int i = 1; i < n; i++) {
            //不包括he[i]
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        for (int j = n - 2; j >= 1; j--) {
            rightMax[j] = Math.max(rightMax[j +1], height[j + 1]);
        }

        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min-height[i]>0)
            {
                res+=min-height[i];
            }
        }
        return res;

    }
}
