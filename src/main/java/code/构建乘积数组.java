package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/11 上午9:30
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-11 09:30
 */
public class 构建乘积数组 {

    public int[] constructArr(int[] a) {
        if (a.length==0)
        {
            return new int[0];
        }
        int n=a.length;
        int[] b=new int[a.length];

        b[0]=1;
        //求左下角的数值
        for (int i=1;i<n;i++)
        {
            b[i]=b[i-1]*a[i-1];
        }
        /*上面所有左下角的数值已经求出来了*/
        int tmp=1;
        for (int i=n-2;i>=0;i--)
        {
            tmp*=a[i+1];
            b[i]*=tmp;
        }
        return b;


    }
}
