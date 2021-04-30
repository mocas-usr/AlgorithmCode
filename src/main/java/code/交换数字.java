package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/4/30 下午8:21
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-04-30 20:21
 */
public class 交换数字 {
    public int[] swapNumbers(int[] numbers) {
        int a = numbers[0];
        int b = numbers[1];
        a = a + b;
        b = a - b;
        a = a - b;
        return new int[]{a,b};



    }
}
