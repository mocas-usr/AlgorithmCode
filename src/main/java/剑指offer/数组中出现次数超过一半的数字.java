package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/15 下午9:17
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-15 21:17
 */
public class 数组中出现次数超过一半的数字 {

    public int MoreThanHalfNum_Solution(int[] array) {

        int num = array[0];
        int vote = 0;

        for (int arr : array) {
            if (vote == 0) {
                num = arr;
            }
            if (arr != num) {
                vote--;
            } else {
                vote++;
            }


        }
        return num;
    }

    @Test
    public void test() {
        int[] array={1,2,3,4,6,7,5,3,2,2,2,2,2,2,2,2};
        int res=MoreThanHalfNum_Solution( array);
        System.out.println(res);
    }
}
