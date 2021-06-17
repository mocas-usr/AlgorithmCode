package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 上午9:51
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.ArrayList;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-17 09:51
 */
public class 和为S的两个数字 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res=new ArrayList<>();
        if (array.length==0)
        {
            return new ArrayList<>();
        }
        int left=0;
        int right=array.length-1;
        int min=Integer.MAX_VALUE;
        while (left<right)
        {
            int total=array[left]+array[right];
            if (total<sum)
            {
                left++;
            }else if (total>sum)
            {
                right--;
            }else
            {
                int temp=array[left]*array[right];
                if (temp<min)
                {
                    min=array[left]*array[right];
                    res=new ArrayList<>();
                    res.add(array[left]);
                    res.add(array[right]);
                }
                left++;
                right--;
            }

        }
        return res;
    }

    @Test
    public void test()
    {
        int [] array={1,2,4,7,11,15};
        ArrayList<Integer> res=FindNumbersWithSum(array,15);
        System.out.println(res);
    }
}
