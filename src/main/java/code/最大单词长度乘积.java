package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/12 下午8:27
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-12 20:27
 */
public class 最大单词长度乘积 {

    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        int[] lens = new int[n];

        int bitmask = 0;
        //求mask数值，标记是否重复
        for (int i = 0; i < n; i++) {
            bitmask = 0;
            for (char ch : words[i].toCharArray()) {
                bitmask |= 1 << (ch - 'a');

            }
            masks[i] = bitmask;
            lens[i] = words[i].length();
        }

        int max=0;
        for (int i = 0; i < words.length; i++)
            for (int j = i + 1; j < words.length; j++) {
                //不等于0，说明有重复的字符
                if ((masks[i] & masks[j]) == 0) {
                    max=Math.max(max,lens[i]*lens[j]);
                }
            }
        return max;
    }
}
