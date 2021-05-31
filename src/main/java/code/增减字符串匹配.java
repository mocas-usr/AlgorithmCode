package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/21 上午11:12
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-21 11:12
 */
public class 增减字符串匹配 {

    public int[] diStringMatch(String s) {

        int left = 0;
        int right = s.length();
        int n = s.length();
        int[] res = new int[s.length() + 1];
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'I') {
                res[i] = left++;
            } else {
                res[i] = right--;
            }

        }
        res[n] = left;
        return res;

    }
}
