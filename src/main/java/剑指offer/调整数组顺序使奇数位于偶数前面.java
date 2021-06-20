package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 上午11:03
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.List;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-15 11:03
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public int[] reOrderArray (int[] array) {
        // write code here
        List<Integer> ji=new LinkedList<>();
        List<Integer> ou=new LinkedList<>();

        for (int num:array)
        {
            if ((num&1)==1)
            {
                ji.add(num);
            }
            else
            {
                ou.add(num);
            }
        }
        int k=0;
        int[] res=new int[array.length];
        for (int i=0;i<ji.size();i++)
        {
            res[k++]=ji.get(i);
        }

        for (int i=0;i<ou.size();i++)
        {
            res[k++]=ou.get(i);
        }
        return res;


    }
}
