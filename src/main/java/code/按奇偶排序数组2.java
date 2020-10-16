package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/13 上午10:45
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-13 10:45
 */
public class 按奇偶排序数组2 {

    public int[] sortArrayByParityII(int[] A) {

        int[] result=new int[A.length];
        //先处理偶数
        int t=0;
        //遍历方法
        for (int x:A)
        {

            if (x%2==0)
            {
                result[t]=x;
                t=t+2;
            }
        }
        t=1;
        for (int x:A)
        {

            if (x%2==1)
            {
                result[t]=x;
                t=t+2;
            }
        }
       return result;

    }

    //双指针法，
    public int[] sortSolution2(int[] A)
    {

        int ou=0;
        int ji=1;
        //只要偶数的位置全部正确，奇数也就正确了
        for(;ou<A.length;ou+=2)
        {
            if (A[ou]%2==1)//偶数位不是偶数
            {
               //寻找第一个奇数位，是偶数的
               while (A[ji]%2==1)
               {
                   ji+=2;
               }

                //偶数位交换成奇数
                int tmp=A[ou];
                A[ou]=A[ji];
                A[ji]=tmp;
                ji+=2;
            }

        }
        return A;

    }

    @Test
    public void test()
    {
        int[] nums={4,2,5,7};
        int[] num=sortSolution2(nums);
        System.out.println(Arrays.toString(num));


    }
}
