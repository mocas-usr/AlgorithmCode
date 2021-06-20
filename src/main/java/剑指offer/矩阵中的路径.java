package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/18 下午6:21
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-18 18:21
 */
public class 矩阵中的路径 {
    boolean res;

    public boolean hasPath(char[][] matrix, String word) {
        // write code here
        boolean res = false;
        char[] str = word.toCharArray();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                boolean ans = dfs(matrix, i, j, 0, str);
                if (ans) {
                    return true;
                }
            }
        }
        return false;
    }

    //深度遍历
    public boolean dfs(char[][] nums, int i, int j, int index, char[] str) {
        //终止条件
        if (index == str.length) {
            return true;
        }
        //剪枝
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length) {
            return false;
        }
        if (nums[i][j] != str[index]) {
            return false;
        }
        //当前选择
        char ch = nums[i][j];
        nums[i][j] = '.';
        //下一路径
        boolean ans = dfs(nums, i + 1, j, index + 1, str) || dfs(nums, i - 1, j, index + 1, str)
                || dfs(nums, i, j + 1, index + 1, str) || dfs(nums, i, j - 1, index + 1, str);
        //恢复现场
        nums[i][j] = ch;
        return ans;

    }
}
