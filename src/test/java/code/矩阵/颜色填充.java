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


    int oldColor;
    boolean[][] visit;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        visit = new boolean[image.length][image[0].length];

        oldColor = image[sr][sc];

        dfs(image, sr, sc, newColor);
        return image;

    }

    public void dfs(int[][] image, int i, int j, int newColor) {

        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || visit[i][j]) {
            return;
        }

        //剪枝
        if (image[i][j]!=oldColor)
        {
            return;
        }
        //当前操作
        image[i][j]=newColor;
        visit[i][j]=true;
        //下一路径
        dfs(image,i-1,j,newColor);
        dfs(image,i+1,j,newColor);
        dfs(image,i,j-1,newColor);
        dfs(image,i,j+1,newColor);
    }
}
