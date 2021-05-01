package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/17 下午4:25
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-04-17 16:25
 */
public class 一次编辑 {
    public boolean oneEditAway(String first, String second) {


        int m = first.length();
        int n = second.length();

        if (Math.abs(m - n) > 1) {
            return false;
        }
        int len = m - n;
        int left = 0;
        int count = 1;//操作次数
        int right = 0;
        while (left < m && right < n) {
            if (first.charAt(left) != second.charAt(right)) {
                if (len == 1) {
                    //如果第一个字符串长
                    right--;
                } else if (len == -1) {
                    left--;
                }

                count--;
            }
            left++;
            right++;
            if (count < 0) {
                return false;
            }
        }
        return true;
    }
}
