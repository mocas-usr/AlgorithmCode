package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/8 下午4:26
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-08 16:26
 */
public class 数组中的逆序对 {
    //全局变量
    int res;

    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        res = 0;
        for (int i=0;i<nums.length;i++)
        {
            dfs(nums, nums[0],i);
        }

        return res;
    }

    public void dfs(int[] nums, int cur,int index) {
        //终止条件
        if (index == nums.length) {
            return;
        }
        //剪枝
        if (cur > nums[index]) {
            res += 1;
        }
      dfs(nums,cur,index+1);


    }
}
