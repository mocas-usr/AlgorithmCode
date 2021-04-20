package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/10 下午4:25
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-10 16:25
 */
public class 分割回文串 {

    //全局变量
    List<List<String>> res = new LinkedList<>();
    List<String> list = new LinkedList<>();

    //动态规划
    public List<List<String>> partition(String s) {

        int n = s.length();
        //表示i,j是否是回文串
        boolean[][] dp = new boolean[n][n];

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {//说明两边字符相等
                    if (j - i < 3) {
                        dp[i][j] = true;
                    }else
                    {
                        dp[i][j] = dp[i +1][j - 1];
                    }
                }


            }
        }
        //起始搜索路径
        dfs(0, n, dp, s);
        return res;

    }

    public void dfs(int index, int len, boolean[][] dp, String s) {
        //终止条件
        if (index == len) {
            res.add(new LinkedList<>(list));
            return;
        }
        //for 循环列表
        for (int i = index; i < len; i++) {
            //从index往后搜索。接力
            if (dp[index][i]) {
                //当前选择
                list.add(s.substring(index, i + 1));
                //下一路径
                dfs(i + 1, len, dp, s);
                //恢复现场
                list.remove(list.size() - 1);
            }
        }
    }


    @Test
    public void test()
    {
        String s = "abbab";
        List<List<String>> res=partition(s);
        System.out.println(res);
    }
}
