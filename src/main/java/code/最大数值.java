package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/12 下午10:37
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-12 22:37
 */
public class 最大数值 {
    public int maximum(int a, int b) {

        long diff = Math.abs((long)a - (long)b);
        return (int) ((long)((long)a + (long)b + diff) / 2);


    }
}
