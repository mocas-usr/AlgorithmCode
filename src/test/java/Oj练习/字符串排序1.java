package Oj练习;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/2 下午9:18
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-02 21:18
 */
//采用hasNextXxxx() 的话，后面也要用nextXxxx():
//
//    比如前面用hasNextLine()，那么后面要用 nextLine() 来处理输入;
//    后面用 nextInt() 方法的话,那么前面要使用 hasNext()方法去判断.
public class 字符串排序1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String str=sc.nextLine();
            int num=Integer.valueOf(str);
            String[] numStrs=sc.nextLine().trim().split(" ");
            Arrays.sort(numStrs);
            for (String s:numStrs)
            {
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
}
