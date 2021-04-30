package code.矩阵;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/22 上午11:08
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-22 11:08
 */
/*最短路径（带权值的网格）：dp[i][j] = min{dp[i - 1][j], dp[i][j - 1]} + grid[i][j]
所有路径（包含障碍，1表示障碍，0表示通行）：if grid[i][j] ==0 :dp[i][j] = dp[i - 1][j] + dp[i][j - 1],否则,dp[i][j] = 0
所有路径（不包含障碍）,状态方程同2中if，也可以直接返回组合数C(m+n)(m)，m，n为网格的行数和列数。

*/
public class 迷路的机器人 {
}
