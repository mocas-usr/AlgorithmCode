package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/10 下午8:24
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-10 20:24
 */
public class 矩阵中的路径 {


    //回溯算法
    public boolean exist(char[][] board, String word) {
        //拆分字符串
        char[] words=word.toCharArray();

        Boolean res;
        //搜索起点
        for (int i=0;i<board.length;i++)
            for (int j=0;j<board[0].length;j++)
            {
                //i,j代表搜索的起始位置
                //0代表搜索到单词第几个位置
                res=dfs(board,i,j,words,0);
                if (res)
                {
                    return true;
                }
            }

        return false;

    }
    //回溯查询
    public Boolean dfs(char[][] board,int i,int j,char[] words,int index)
    {
        //搜索停止条件
        if (i>=board.length||j>=board[0].length ||i<0 || j<0)
        {
            return false;
        }
        if (board[i][j]!=words[index])
        {
            return false;
        }

        //走到这里说明已经满足条件，继续往下搜索
        //说明搜索到最后一个字符并且满足条件
        if (index==words.length-1)
        {
            return true;
        }
        //首先把此位置成不等字符，防止再次查找
        char tmp=board[i][j];
        board[i][j]='.';
        //往下继续搜索
        Boolean res;
        if (dfs(board,i+1,j,words,index+1) ||dfs(board,i-1,j,words,index+1)
        || dfs(board,i,j+1,words,index+1) ||dfs(board,i,j-1,words,index+1))
        {
            res=true;
        }else
        {
            res=false;
        }
        //需要回溯时，将board返回原本的
        board[i][j]=tmp;

        return res;

    }

    @Test
    public void test(){
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word="ABCCED";
        exist(board,word);

    }

}
