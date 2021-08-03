package code.矩阵;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/25 下午3:58
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-25 15:58
 */
public class 机器人的运动范围 {

    boolean[][] visit;

    public int movingCount(int m, int n, int k) {


        visit = new boolean[m][n];
       return dfs(m, n, 0, 0, k);
    }

    public int dfs(int m, int n, int i, int j, int k) {
        if (i<0 || i>=m ||j<0 ||j>=n || visit[i][j])
        {
            return 0;
        }
        if (i%10+i/10+j/10+j%10>k)
        {
            return 0;
        }

        //当前选择
        visit[i][j]=true;
        int res=dfs(m,n,i-1,j,k)+dfs(m,n,i+1,j,k)+dfs(m,n,i,j+1,k)+dfs(m,n,i,j-1,k)+1;
        return res;

    }
}
