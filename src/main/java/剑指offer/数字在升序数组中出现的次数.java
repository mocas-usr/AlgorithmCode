package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/16 下午8:55
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-16 20:55
 */
public class 数字在升序数组中出现的次数 {

    public int GetNumberOfK(int [] array , int k) {
        int count=0;

        for (int num:array)
        {
            if (num==k)
            {
                count++;
            }
            if (num>k)
            {
                break;
            }
        }

        return count;
    }

}
