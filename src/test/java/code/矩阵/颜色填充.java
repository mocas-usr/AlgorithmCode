package code.矩阵;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/13 下午7:07
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-13 19:07
 */
public class 颜色填充 {

    int[][] path = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int newcolor;
    int oldcolor;
    boolean[][] visit;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        visit = new boolean[image.length][image[0].length];
        oldcolor = image[sr][sc];
        newcolor = newColor;
        dfs(image, sr, sc);
        return image;
    }

    public void dfs(int[][] image, int i, int j) {
        //终止条件
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || visit[i][j]) {
            return;
        }

        //当前选择
        if (image[i][j]==oldcolor)
        {
            image[i][j]=newcolor;
            visit[i][j]=true;
            //下一路径
//            for (int k=0;k<path.length;k++)
//            {
//                dfs(image,i+path[k][0],j+path[k][1]);
//            }
            dfs(image,i+1,j);
            dfs(image,i-1,j);
            dfs(image,i,j+1);
            dfs(image,i,j-1);
        }
    }
}
