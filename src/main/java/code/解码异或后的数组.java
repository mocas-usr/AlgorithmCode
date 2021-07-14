package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/23 下午7:41
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-23 19:41
 */
public class 解码异或后的数组 {
    public int[] decode(int[] encoded, int first) {

        int n = encoded.length;
        int[] arr = new int[n + 1];

        arr[0] = first;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] ^ encoded[i - 1];
        }
        return arr;
    }

}
