package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 上午11:19
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-17 11:19
 */
public class 求1 {

    //递归
    public int Sum_Solution(int n) {

        if (n==1)
        {
            return 1;
        }
        int sum=0;
        sum=Sum_Solution(n-1)+n;
        return sum;
    }
}
