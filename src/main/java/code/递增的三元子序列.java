package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/15 上午10:19
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-15 10:19
 */
public class 递增的三元子序列 {

    public boolean increasingTriplet(int[] nums) {

        if (nums.length < 3) {
            return false;
        }

        //
        int three=Integer.MIN_VALUE;
        int two=Integer.MIN_VALUE;
        for (int i=nums.length-1;i>=0;i--)
        {
            if (nums[i]>=three)
            {
                three=nums[i];
            }else if (nums[i]>=two)
            {
                two=nums[i];
            }else
            {
                return true;
            }
        }
        return false;
    }


}
