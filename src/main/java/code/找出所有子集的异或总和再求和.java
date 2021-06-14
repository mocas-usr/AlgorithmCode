package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/8 上午10:43
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-08 10:43
 */
public class 找出所有子集的异或总和再求和 {
    int res = 0;

    public int subsetXORSum(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        dfs(nums, 0, 0);

        return res;

    }

    public void dfs(int[] nums, int index, int or_sum) {
        //终止条件
        if (index==nums.length)
        {
            res+=or_sum;
            return;
        }

        //当前选择
        //下一路径
        //添加当前数值
        dfs(nums,index+1,or_sum^nums[index]);
        dfs(nums,index+1,or_sum);
        //恢复现场
    }
}
