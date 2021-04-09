package code.递归;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/15 下午9:15
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-12-15 21:15
 */
public class 矩阵中的路径 {


    public boolean exist(char[][] board, String word) {

        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                flag = dfs(board, word, i, j, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dfs(char[][] board, String word, int i, int j, int index) {
        //终止条件
        if (index == word.length()) {
            return true;
        }
        //剪枝
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        } else {
            //做选择
            char temp = board[i][j];
            board[i][j] = '.';
            //下一路径
            boolean ans = dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i - 1, j, index + 1)
                    || dfs(board, word, i, j - 1, index + 1) || dfs(board, word, i, j + 1, index + 1);

            //恢复现场

            board[i][j] = temp;
            return ans;
        }

    }


}
