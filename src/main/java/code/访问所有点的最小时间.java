package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/20 上午9:10
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-10-20 09:10
 */
/*平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。

        你可以按照下面的规则在平面上移动：

        每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
        必须按照数组中出现的顺序来访问这些点。

      */
public class 访问所有点的最小时间 {
    public int minTimeToVisitAllPoints(int[][] points) {
        //起始坐标
        int x0=points[0][0];
        int y0=points[0][1];
        int sum=0;
        for (int i=0;i<points.length;i++)
        {
            int x1=points[i][0];
            int y1=points[i][1];
            //两点之间的距离是
            sum=sum+Math.max(Math.abs(x0-x1),Math.abs(y0-y1));
            x0=points[i][0];
            y0=points[i][1];

        }
        return sum;


    }

}
