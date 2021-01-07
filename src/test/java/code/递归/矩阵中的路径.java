package code.递归;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/15 下午9:15
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-15 21:15
 */
public class 矩阵中的路径 {

    public boolean exist(char[][] board, String word) {
        char[] words=word.toCharArray();//拆分字符串
        //起始搜索
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }

        //搜索不到
        return false;

    }
    //i,j代表搜寻位置，k代表搜索到位置
    public boolean dfs(char[][] board,char[] words,int i,int j,int k)
    {
        //终止条件
        if (k==words.length)
        {
            return true;
        }
        //剪枝,如果不符条件，就不进行搜索
        if (i>=board.length ||i<0 ||j>=board[0].length ||j<0 ||board[i][j]!=words[k])
        {
            return false;
        }
        //for 选择列表
        board[i][j]='.';//说明已经搜索过了，避免重复搜索

        //下一路径,其实四个搜索路径
        boolean res = dfs(board, words, i + 1, j, k + 1) || dfs(board, words, i - 1, j, k + 1) ||
                dfs(board, words, i, j + 1, k + 1) || dfs(board, words, i , j - 1, k + 1);
        //恢复现场
        board[i][j]=words[k];
        return res;
    }

    //全局变量
    //用于恢复现场
    boolean flag;
    public boolean exist2(char[][] board, String word)
    {
        flag=false;//默认搜索不到
        char[] words=word.toCharArray();//拆分字符串
        //起始搜索
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                hdfs(board, words, i, j, 0);//逐一作为起点
                if (flag)
                {
                    return true;
                }
            }
        }

        //搜索不到
        return flag;
    }

    public void hdfs(char[][] board,char[] words,int i,int j,int k)
    {
        //终止条件
        if (k==words.length)
        {
            flag=true;
            return;
        }
        //剪枝
        //剪枝,如果不符条件，就不进行搜索
        if (i>=board.length ||i<0 ||j>=board[0].length ||j<0 ||board[i][j]!=words[k])
        {
            return;
        }
        //for 选择列表
        board[i][j]='.';//说明已经搜索过了，避免重复搜索

        //搜索路径列表
        hdfs(board, words, i + 1, j, k + 1);
        hdfs(board, words, i - 1, j, k + 1);
        hdfs(board, words, i, j + 1, k + 1);
        hdfs(board, words, i , j - 1, k + 1);
        board[i][j]=words[k];
        //恢复现场
        return;

    }



}
