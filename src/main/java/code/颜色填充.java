package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/12 下午10:04
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-12 22:04
 */
public class 颜色填充 {
    int color;
    int src;
    int[][] path = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visit;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        color = newColor;
        visit = new boolean[image.length][image[0].length];
        src = image[sr][sc];//坐标的值
        dfs(image, sr, sc);
        return image;
    }

    public void dfs(int[][] image, int i, int j) {
        //终止条件
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length) {
            return;
        }
        if (visit[i][j]) {
            return;
        }
        //当前选择
        visit[i][j] = true;
        if (image[i][j] == src) {
            image[i][j] = color;
            for (int k = 0; k < path.length; k++) {
                dfs(image, i + path[k][0], j + path[k][1]);
            }
        }
    }

    @Test
    public void test() {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1, sc = 1, newColor = 2;
        int[][] res = floodFill(image, sr, sc, newColor);
        System.out.println(res);
    }
}
