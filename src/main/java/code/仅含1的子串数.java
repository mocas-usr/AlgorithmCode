package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/8 上午9:32
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-08 09:32
 */
public class 仅含1的子串数 {
    //双指针
    public int numSub(String s) {

        final int MODULO = 1000000007;
        long total = 0;
        int length = s.length();
        long consecutive = 0;


        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '0') {
                total += consecutive * (consecutive + 1) / 2;
                total %= MODULO;
                consecutive = 0;
            } else {
                consecutive++;
            }
        }
        total += consecutive * (consecutive + 1) / 2;
        total %= MODULO;
        return (int) total;
    }
}
