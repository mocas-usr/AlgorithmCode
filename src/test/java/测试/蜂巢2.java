package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/14 下午8:20
 * @email: wangyuhang_mocas@163.com
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-14 20:20
 */
public class 蜂巢2 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String r1 = r.readLine();
        String r2 = r.readLine();
        int m = Integer.parseInt(r1);
        int n = Integer.parseInt(r2);
        char[][] c = new char[m][n];
        for(int i=0;i<m;i++){
            String[] r3 = r.readLine().trim().split(" ");

            for(int j=0;j<n;j++){
                c[i][j] = r3[j].toCharArray()[0];
            }
        }
        int numcounts=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(c[i][j] == 'C'){
                    numcounts++;
                    dfs(c,i,j);
                }
            }
        }
        System.out.println(numcounts);
    }

    public static void dfs(char[][] grid,int r,int c){
        int nr = grid.length;
        int nc = grid[0].length;
        if(r<0 || r>=nr || c<0 || c>=nc || grid[r][c] == 'P'){
            return;
        }
        grid[r][c] = 'P';
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r+1,c-1);
        dfs(grid,r-1,c+1);

    }

}
