package code.矩阵;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/16 上午9:13
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-16 09:13
 */
public class 有序矩阵中第K小的元素 {

    public int kthSmallest(int[][] matrix, int k) {

        int m=matrix.length;
        int n=matrix[0].length;
        int left=matrix[0][0];
        int right=matrix[m-1][n-1];

        while (left<=right)
        {
            int mid=left+(right-left)/2;
            //查询矩阵<=mid的个数
            int count=findNum(matrix,mid);
            if (count>k)
            {
                right=mid-1;
            }else if (count<k){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return left;
    }

    public int findNum(int[][] matrix, int mid)
    {
        int m=matrix.length;
        int n=matrix[0].length;

        int i=m-1;
        int j=0;
        int res=0;
        while (i>=0 &&j<n)
        {
            if (matrix[i][j]<=mid)
            {
                res+=i+1;
                j++;

            }
            else if (matrix[i][j]>mid)
            {
                i--;
            }
        }
        return res;

    }

}
