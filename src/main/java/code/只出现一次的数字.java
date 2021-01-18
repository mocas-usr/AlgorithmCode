package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/9 20:40
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-09 20:40
 */
public class 只出现一次的数字 {
    //位运算
    public int singleNumber(int[] nums) {
//    if (nums.length==0)
        int res=nums[0];
       for (int i=1;i<nums.length;i++)
       {
           res=res^nums[i];
       }
        return res;
    }
}
