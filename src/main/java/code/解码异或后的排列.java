package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/23 下午7:48
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-23 19:48
 */
public class 解码异或后的排列 {

    public int[] decode(int[] encoded) {

        int n = encoded.length + 1;
        //n个数，n是奇数
        //x1x2x3xn
        int arrSum = 0;
        for (int i = 1; i <= n; i++) {
            arrSum ^= i;
        }
        //求原数组第一个数
        //偶数位相加，n-1为偶数
        int enSum = 0;
        //x2x3x45....xn-1xn
        for (int i = 1; i < encoded.length; i += 2) {
            enSum ^= encoded[i];
        }
        int first = arrSum ^ enSum;
        int[] res = new int[n];
        res[0] = first;

        for (int i = 1; i < n; i++) {
            res[i] = encoded[i - 1] ^ res[i - 1];
        }
        return res;
    }
}
