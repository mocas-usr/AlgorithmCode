package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 上午10:53
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-17 10:53
 */
public class 扑克牌顺子 {

    public boolean IsContinuous(int [] numbers) {

        Arrays.sort(numbers);
        int joke=0;
        //先检查0的个数和是否有重复
        for (int i=0;i<numbers.length-1;i++)
        {
            if (numbers[i]==0)
            {
                joke++;
            }else
            {
                if (numbers[i]==numbers[i+1])
                {
                    return false;
                }
            }


        }

        int n=numbers.length;
        //处理
        if (numbers[4]-numbers[joke]<=4)
        {
            return true;
        }else
        {
            return false;
        }

    }
}
