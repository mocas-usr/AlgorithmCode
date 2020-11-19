package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/13 上午9:55
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-13 09:55
 */
public class 除自身以外数组的乘积 {
    //上下三角，空间复杂度为1
    public int[] productExceptSelf(int[] nums) {

        //结果存放数组，不算空间
        int n=nums.length;
        int[] res=new int[n];
        //存储当前元素的左边元素乘积，下三角
        int p=1,q=1;
        //将nums[i]的左半边数值乘积已经求出
        for (int i=0;i<nums.length;i++)
        {
            res[i]=p;
            p*=nums[i];
        }
        //右半边，下三角
        for (int i=n-1;i>=0;i--)
        {
            res[i]*=q;
            q*=nums[i];
        }
        return res;

    }
}
