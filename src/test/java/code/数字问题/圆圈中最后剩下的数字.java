package code.数字问题;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/9 下午3:28
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-09 15:28
 */
public class 圆圈中最后剩下的数字 {

    public int lastRemaining(int n, int m) {

        //只有一个人的时候
        int index=0;
        for (int i=2;i<=n;i++)
        {
            //每次相当于那个人的位置移动m次
            index=(index+m)%i;
        }
        return index;

    }
}
