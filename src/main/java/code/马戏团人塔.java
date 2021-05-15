package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/15 上午11:01
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-15 11:01
 */
public class 马戏团人塔 {

    public int bestSeqAtIndex(int[] height, int[] weight) {

        int m = height.length;
        int[][] person = new int[m][m];

        for (int i = 0; i < m; i++) {
            person[i]=new int[]{height[i],weight[i]};
        }
        //先按身高排
        Arrays.sort(person,(x,y)->(x[0]-y[0]));
        //dp[i]代表(0,i)叠了多少个人
        int[] dp = new int[m];
        int res=0;
        dp[0]=1;
        for (int[] pair : person) {
            int i = Arrays.binarySearch(dp, 0, res, pair[1]);
            if (i < 0)
                i = -(i + 1);
            dp[i] = pair[1];
            if (i == res)
                ++res;
        }
        return res;

    }
}
