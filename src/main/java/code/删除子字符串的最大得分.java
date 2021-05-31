package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/31 上午10:25
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Stack;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-31 10:25
 */
public class 删除子字符串的最大得分 {
    //栈解法
    public int maximumGain(String s, int x, int y) {
        if (s == null) {
            return 0;
        }
        int sum = 0;
        //贪心
        if (x > y) {
            LastSSum ls = deleteChars(s, 'a','b', x);
            sum = sum + ls.sum;
            LastSSum ls2 = deleteChars(ls.lastS, 'b','a', y);
            sum = sum + ls2.sum;
        } else {
            LastSSum ls = deleteChars(s, 'b','a', y);
            sum = sum + ls.sum;
            LastSSum ls2 = deleteChars(ls.lastS, 'a','b', x);
            sum = sum + ls2.sum;
        }
        return sum;
    }

    private LastSSum deleteChars(String s, char first, char second, int record) {
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        int sum = 0;
        int index = 0;
        while (index < s.length()) {
            if (stack.isEmpty()) {
                stack.push(chs[index]);
            } else if (chs[index] == second && stack.peek() == first) {
                sum = sum + record;
                stack.pop();
            } else {
                stack.push(chs[index]);
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return new LastSSum(sb.reverse().toString(), sum);
    }

    class LastSSum{
        String lastS;
        int sum;

        public LastSSum(String lastS, int sum) {
            this.lastS = lastS;
            this.sum = sum;
        }
    }

    @Test
    public void test()
    {
        String s = "cdbcbbaaabab";
        int x = 4, y = 5;
        int res=maximumGain(s, x,  y);
        System.out.println(res);
    }
}
