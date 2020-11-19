package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/9 上午9:58
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-11-09 09:58
 */
public class 顺时针打印矩阵 {

    public int[] spiralOrder(int[][] matrix) {
        int row=matrix.length;//行数
        if (row==0)
        {
            return new int[0];
        }
        int col=matrix[0].length;//列数


        int left=0,right=col-1,top=0,bottom=row-1;//边界
        int id=0;
        int[] res=new int[row*col];//存储结果

        while (true)
        {
            //从左往右打印，
            for (int i=left;i<=right;i++)
            {
                res[id++]=matrix[top][i];
            }
            //如果超出下边界
            if (++top>bottom)
            {
                break;
            }
            //从上到下打印
            for (int i=top;i<=bottom;i++)
            {
                res[id++]=matrix[i][right];

            }
            if (--right<left)
            {
                break;
            }
            //从右往左打印
            for (int i=right;i>=left;i--)
            {
                res[id++]=matrix[bottom][i];
            }
            if (--bottom<top)
            {
                break;
            }
            //从下往上
            for (int i=bottom;i>=top;i--)
            {
                res[id++]=matrix[i][left];
            }
            if (++left>right)
            {
                break;
            }
        }
        return res;

    }
}
