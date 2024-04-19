package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/11 16:49
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-11 16:49
 */
public class 石子游戏 {

    int max=Integer.MIN_VALUE;
    public int[] result(int A, int B, int n, int[] e, int[] a) {
        // write code here
//        int sum=0;
        dfs(0,e,A,0);
        return new int[0];
    }

    public void dfs(int index,int[] nums,int total,int sum)
    {
        //终止条件
        if (index==nums.length)
        {

            return;
        }
        //剪枝
        //操作能量用完
        if (total==0)
        {
            sum=0;
        }

        //当前操作
        //消耗能量，避免添加

    }
}
