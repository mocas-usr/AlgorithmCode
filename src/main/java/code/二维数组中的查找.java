package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/10 下午9:27
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-10 21:27
 */
public class 二维数组中的查找 {
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix.length==0)
        {
            return false;
        }
        int i=0,j=0;
        //多少行
        int imax=matrix.length-1;
        //多少列
        int jmax=matrix[0].length-1;
        while (i<=imax && j<=jmax)
        {
            int imid=i+(imax-i)/2;
            int jmid=j+(jmax-j)/2;
            if (target>matrix[imid][jmid])
            {
                jmax=jmid-1;
            }else if (target<matrix[imid][jmid])
            {
                i=imid+1;
            }else if (target==matrix[imid][jmid])
            {
                return true;
            }
        }

        return false;

    }

    //标志位法
    public boolean findNumberIn2DArray(int[][] matrix, int target)
    {
        //左下角为标志位
        int i=matrix.length-1;
        int j=0;
        while (i>=0&&j<matrix[0].length)
        {
            //说明所在行一定大于
            if (matrix[i][j]>target)
            {
                i--;
            }else if (matrix[i][j]<target)
            {
                j++;
            }
            else if (matrix[i][j]==target)
            {
                return true;
            }
        }
        return false;
    }

}
