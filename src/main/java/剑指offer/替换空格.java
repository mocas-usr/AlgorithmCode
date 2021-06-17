package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 上午9:25
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 09:25
 */
public class 替换空格 {
    public String replaceSpace(String s) {
        // write code here

        int n = s.length();
        if (n == 0) {
            return "";
        }

        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') {
                sb.append("%20");
            }else
            {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
