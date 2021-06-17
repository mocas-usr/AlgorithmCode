package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 上午11:36
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-17 11:36
 */
public class 构建乘积数组 {

    public int[] multiply(int[] A) {

        int n=A.length;
        //先构建左下角
        //代表截止到A[i]-1的乘积
        int[] b = new int[A.length];
        b[0]=1;
        //前缀乘积
        int preSum=1;
        for (int i = 1; i < A.length; i++) {
            preSum*=A[i-1];
            b[i]=preSum;
        }

        //再通过右下角构建,从右边处理,
        //后缀乘积,除去当前的后缀乘积
        preSum=1;
        for (int j=n-2;j>=0;j--)
        {
            preSum*=A[j+1];
            b[j]*=preSum;
        }
        return b;




    }


}
