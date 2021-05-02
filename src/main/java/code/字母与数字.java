package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/1 下午4:19
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-01 16:19
 */
public class 字母与数字 {
    public String[] findLongestSubarray(String[] array) {
        int len = array.length;
        int[] arr = new int[2 * len + 1];
        Arrays.fill(arr, -2);
        arr[len] = -1;
        int count = 0, start = -1, max = 0;
        for (int i = 0; i < len; i++) {
            char ch = array[i].charAt(0);
            count += Character.isDigit(ch) ? 1 : -1;
            if (arr[count + len] == -2)
                arr[count + len] = i;
            else {
                if (i - arr[count + len] > max) {
                    start = arr[count + len];
                    max = Math.max(max, i - start);
                }
            }
        }
        return Arrays.copyOfRange(array, start + 1, start + 1 + max);
    }

    @Test
    public void test() {
        String [] array={"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
        String[] res=findLongestSubarray(array);
        System.out.println(res);
    }


}
