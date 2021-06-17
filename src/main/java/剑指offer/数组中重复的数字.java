package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 上午11:33
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-17 11:33
 */
public class 数组中重复的数字 {
    public int duplicate(int[] numbers) {
        // write code here
        int[] count = new int[numbers.length];

        for (int num : numbers) {
            if (count[num]++ == 1) {
                return num;
            }
        }
        return -1;
    }
}
