package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/9 上午11:19
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-09 11:19
 */
public class 圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        int pos=0;//最后留下来的数字
        for (int i=2;i<=n;i++)//i代表长度
        {
            pos=(pos+m)%i;
        }
        return pos;

    }
}
