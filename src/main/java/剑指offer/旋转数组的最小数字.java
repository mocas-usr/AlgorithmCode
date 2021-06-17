package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 上午10:14
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-15 10:14
 */
public class 旋转数组的最小数字 {
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }

        for (int i=1;i<array.length;i++)
        {
            if (array[i]<array[i-1])
            {
                return array[i];
            }
        }
        return array[0];


    }
}
