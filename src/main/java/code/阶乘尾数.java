package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/14 上午11:10
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-14 11:10
 */
public class 阶乘尾数 {
    //求因式里面5的个数
    public int trailingZeroes(int n) {

        int res=0;
        while (n>=5)
        {
            res+=n/5;
            n=n/5;
        }
        return res;

    }
}
