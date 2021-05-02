package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/1 下午4:11
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-01 16:11
 */
public class 消失的数字 {

    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=n*(n+1)/2;
        for (int num:nums)
        {
            sum-=num;
        }
        return sum;

    }
}
