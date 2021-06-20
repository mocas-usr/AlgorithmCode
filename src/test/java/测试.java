/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 下午9:09
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-17 21:09
 */
public class 测试 {
    public static void sortIntegerArray(Integer[] pIntegerArray, int iSortFlag) {
        //降序
        if (iSortFlag == 1) {
            Arrays.sort(pIntegerArray, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }

            });
        }
        //默认是升序
        else {
            Arrays.sort(pIntegerArray);
        }

        for (int i = 0; i < pIntegerArray.length; i++) {
            if (i == pIntegerArray.length - 1) {
                //最后一个空格不能加
                System.out.print(pIntegerArray[i]);
            } else {
                System.out.print(pIntegerArray[i] + " ");
            }
        }
        //没有换行会报错
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //不能缺少while(sc.hasNext())
        while (sc.hasNext()) {
            int times = sc.nextInt();
            Integer[] arr = new Integer[times];
            for (int i = 0; i < times; i++) {
                arr[i] = sc.nextInt();
            }
            int flag = sc.nextInt();
            sortIntegerArray(arr, flag);
        }
    }
}
