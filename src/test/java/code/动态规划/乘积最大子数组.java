package code.动态规划;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/16 13:27
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Map;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-01-16 13:27
 */
public class 乘积最大子数组 {

    //动态规划
    public int maxProduct(int[] nums) {

        if (nums.length==1)
        {
            return nums[0];
        }
        int n=nums.length;
        //以nums[i]结尾的最大数值和最小数值
        int[] maxdp=new int[n];
        int[] mindp=new int[n];
        maxdp[0]=nums[0];
        mindp[0]=nums[0];
        int res= nums[0];
        for (int i=1;i<n;i++)
        {
            maxdp[i]= Math.max(nums[i],Math.max(mindp[i-1]*nums[i],maxdp[i-1]*nums[i]));
            mindp[i]=Math.min(nums[i],Math.min(maxdp[i-1]*nums[i],mindp[i-1]*nums[i]));
            res=Math.max(res,maxdp[i]);
        }
        return res;




    }

    @Test
    public void test() {
        int[] nums = {-3, -1, -1};
        int res = maxProduct(nums);
        System.out.println(res);
    }
}
