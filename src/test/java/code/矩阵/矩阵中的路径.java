package code.矩阵;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/10 下午8:28
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-12-10 20:28
 */
public class 矩阵中的路径 {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                //起始搜索路径
                boolean flag = dfs(board, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dfs(char[][] board, int i, int j, String word, int index) {
        //终止条件
        if (index == word.length()) {
            return true;
        }
        //剪枝
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        //for 选择列表
        //做选择
        char temp = board[i][j];
        board[i][j] = '.';
        //搜索路径
        boolean ans = dfs(board, i, j + 1, word, index + 1) || dfs(board, i + 1, j, word, index + 1)
                || dfs(board, i, j - 1, word, index + 1) || dfs(board, i - 1, j, word, index + 1);
        //恢复现场
        board[i][j] = temp;
        return ans;
    }

}
