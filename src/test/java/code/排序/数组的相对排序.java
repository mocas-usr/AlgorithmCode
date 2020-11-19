package code.排序;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/5 下午6:19
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-05 18:19
 */
public class 数组的相对排序 {
    //计数排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {


        int[] index=new int[1001];//存储arr1
        for (int num:arr1)
        {
            index[num]++;
        }

        int[] result=new int[arr1.length];
        int key=0;
        //先排arr2存在的
        for (int num:arr2)
        {
            //如果arr1存在，则首先存储
            while (index[num]>0)
            {
                result[key++]=num;//存储结果
                index[num]--;
            }
        }
        //存储剩下的
        for (int i=0;i<1001;i++)
        {
            //此时，剩下不在arr2中的
            while (index[i]>0)
            {
                result[key++]=i;
                index[i]--;
            }
        }

        return result;

    }

    @Test
    public void test()
    {
        int[] arr1={2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2={2,1,4,3,9,6};
        relativeSortArray(arr1,arr2);
    }
}
