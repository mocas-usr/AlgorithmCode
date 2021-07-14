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

    boolean[][] visit;

    public boolean exist(char[][] board, String word) {


        visit = new boolean[board.length][board[0].length];

        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean dfs(char[][] board, char[] words, int i, int j, int index) {
        //终止条件
        if (index==words.length)
        {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j]!=words[index]) {
            return false;
        }
        //剪枝
        if (visit[i][j]) {
            return false;
        }

        //当前选择
        visit[i][j]=true;
        boolean res=dfs(board,words,i+1,j,index+1) || dfs(board,words,i,j+1,index+1)
                || dfs(board,words,i-1,j,index+1) || dfs(board,words,i,j-1,index+1);

        visit[i][j]=false;

        return res;
    }



}
