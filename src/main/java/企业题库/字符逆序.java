package 企业题库;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/14 下午5:27
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-14 17:27
 */
public class 字符逆序 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int left = 0;
        int right = str.length() - 1;

        char[] s=str.toCharArray();

        while (left < right) {
            char ch=s[left];
            s[left]=s[right];
            s[right]=ch;
            left++;
            right--;
        }

        System.out.println(String.valueOf(s));
    }
}
