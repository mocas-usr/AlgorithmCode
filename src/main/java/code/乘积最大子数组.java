package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/15 21:39
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-15 21:39
 */
public class 乘积最大子数组
{
    public int maxProduct(int[] nums) {
        int len=nums.length;

        int[] dp=new int[len];
        int maxF=nums[0];
        int minF=nums[0];
        int ans=nums[0];
        for (int i=1;i<len;i++)
        {
            int max=maxF;
            int min=minF;
            maxF=Math.max(maxF*nums[i],Math.max(min*nums[i],nums[i]));
            minF=Math.min(min*nums[i],Math.min(max*nums[i],nums[i]));
            ans=Math.max(maxF,ans);
        }

        return ans;
    }
}
