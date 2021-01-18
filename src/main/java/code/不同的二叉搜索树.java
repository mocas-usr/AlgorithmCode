package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/12 15:31
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-12 15:31
 */
public class 不同的二叉搜索树 {

    //动态规划
    public int numTrees(int n) {
        //结果集
        int[] res=new int[n+1];
        res[0]=1;
        res[1]=1;

        //i代表有几个数值
        for (int i=2;i<=n;i++)
            for (int j=1;j<=i;j++)//代表有j为root时，i个个节点
            {
                //j左边j-1个节点，右边i-j节点
                int num=res[j-1]*res[i-j];
                res[i]+=num;

            }

        return res[n];
    }


}
