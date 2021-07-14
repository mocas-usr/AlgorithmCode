package code.递归;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/3 下午4:29
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-03 16:29
 */
public class 括号生成 {

    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {

        if (n == 0) {
            return new LinkedList<>();
        }

        int left = n;
        int right = n;
        hdfs(left, right);
        return res;
    }

    public void hdfs(int left, int right) {
        //终止条件
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            res.add(sb.toString());
            return;
        }
        //当前操作
        if (left > 0) {
            sb.append("(");
            hdfs(left - 1, right);
            //恢复现场
            sb.deleteCharAt(sb.length() - 1);

        }
        if (right > 0) {
            sb.append(")");
            hdfs(left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

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
