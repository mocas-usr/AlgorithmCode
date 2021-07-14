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

    boolean[][] visit;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        visit = new boolean[board.length][board[0].length];

        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                boolean ans = dfs(board, i, j, words, 0);
                if (ans) {
                    return true;
                }
            }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, char[] word, int index) {
        //终止条件
        if (index == word.length) {
            return true;
        }
        //剪枝
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word[index]) {
            return false;
        }
        if (visit[i][j])
        {
            return false;
        }
        //当前操作
        //标记此时的数据,此时的数据已经有board[i][j]=word【inidex】
//        char temp = board[i][j];
//        board[i][j] = '.';
        visit[i][j]=true;
        //下一路径
        boolean res = dfs(board, i - 1, j, word, index + 1) || dfs(board, i, j - 1, word, index + 1)
                || dfs(board, i, j + 1, word, index + 1) || dfs(board, i + 1, j, word, index + 1);
        //恢复现场
//        board[i][j] = temp;
        visit[i][j]=false;
        return res;

    }


}
