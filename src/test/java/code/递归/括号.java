package code.递归;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/1/4 20:04
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-01-04 20:04
 */
public class 括号 {
    //全局变量
    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {

        if (n == 0) {
            return new LinkedList<>();
        }
        //n代表剩余左右括号个数
        hdfs(n, n);
        return res;
    }

    public void hdfs(int left, int right) {
        //终止条件
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        //剪枝
        if (left > right) {
            return;
        }
        //当前选择
        if (left > 0) {

            sb.append("(");
            hdfs(left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > 0) {
            sb.append(")");
            hdfs(left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        //下一路径
    }


    @Test
    public void test() {
        int n = 3;
        generateParenthesis(n);
        String ss = "abc";

        char[] cc;

        cc = ss.toCharArray();
        String res = new String(cc);
        System.out.println(res);

    }
}
