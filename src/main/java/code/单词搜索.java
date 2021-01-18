package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/12 9:20
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-01-12 09:20
 */
public class 单词搜索 {
    //全局变量



    //回溯
    public boolean exist(char[][] board, String word) {

        //搜索起点
        for(int i=0;i<board.length;i++)
            for (int j=0;j<board[0].length;j++)
            {
                boolean res=dfs(board,word,i,j,0);
                if (res)
                {
                    return true;
                }
            }

        return false;


    }

    //回溯
    public boolean dfs(char[][] board, String word,int i,int j,int index)
    {
        //终止条件
        if (index==word.length())
        {
            return true;
        }
        //剪枝
        if (i<0 ||i>=board.length ||j<0 || j>=board[0].length)
        {
            return false;
        }

        if (board[i][j]!=word.charAt(index))
        {
            return false;
        }

        //for 选择列表
        char temp=board[i][j];
        //做选择
        board[i][j]='.';
        //搜索路径
        boolean ans=dfs(board,word,i+1,j,index+1) || dfs(board,word,i,j+1,index+1) ||
                dfs(board,word,i-1,j,index+1) ||dfs(board,word,i,j-1,index+1);
        //恢复现场
        board[i][j]=temp;
        return ans;
    }
}
