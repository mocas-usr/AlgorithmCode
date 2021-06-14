package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/8 上午11:18
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-08 11:18
 */
public class 有序数组中差绝对值之和 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        //注意是非递减
        int l[]=new int[nums.length];//左侧所有和
        int r[]=new int[nums.length];//右侧所有和
        int ans[]=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            l[i]=l[i-1]+nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--){
            r[i]=r[i+1]+nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            ans[i]=r[i]-l[i]-nums[i]*(nums.length-2*i-1);
        }
        return ans;

    }


    public int dfs(int[] nums, int num, int index, int sum) {
        //终止条件
        if (index == nums.length) {
            return sum;
        }

        //当前选择
        int temp = Math.abs(num - nums[index]);
        //下一路径
        //恢复现场
        int total=dfs(nums, num, index + 1, sum + temp);
        return total;
    }
}
