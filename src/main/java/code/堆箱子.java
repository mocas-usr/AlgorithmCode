package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/13 下午8:25
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-13 20:25
 */
public class 堆箱子 {

    public int pileBox(int[][] box) {

        //以宽度排个序，都是比他小的
        Arrays.sort(box, (x, y) -> (x[0] - y[0]));
        int m = box.length;//箱子的个数
        int res = 0;
        //第i个箱子的高度，包含第box[i]个箱子的最大高度
        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            //排序过后箱子的高度
            //第i个箱子的高度
            dp[i] = box[i][2];
            //求上一个箱子高度
            for (int j = 0; j < i; j++) {
                if (box[j][2] < box[i][2] && box[j][0] < box[i][0] && box[j][1] < box[i][1]) {
                    dp[i] = Math.max(dp[j] + box[i][2], dp[i]);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
