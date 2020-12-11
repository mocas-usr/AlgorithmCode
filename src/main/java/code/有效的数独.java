package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/12/10 下午8:46
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-12-10 20:46
 */
public class 有效的数独 {
    public boolean isValidSudoku(char[][] board) {

        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][9];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][9];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][9];

        //遍历所有点
        for (int i=0;i<9;i++)
            for (int j=0;j<9;j++)
            {
                //如果是.，则换下一个
                if (board[i][j]=='.')
                {
                    continue;
                }
                //代表这行的数字
                int curNum=board[i][j]-'1';
                //如果行或者列，或者box有值
                if (row[i][curNum] ||col[j][curNum] ||block[j/3+(i/3)*3][curNum] )
                {
                    return false;
                }
                //行或者列已经有curnum
                row[i][curNum]=true;
                col[j][curNum]=true;
                //j/3代表横着看，属于第几列，i/3 ）*3代表竖着看，第几个box
                block[j/3+(i/3)*3][curNum]=true;

            }

        return true;


    }
}
