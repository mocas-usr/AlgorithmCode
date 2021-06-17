package 企业题库;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/14 下午3:03
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Scanner;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-14 15:03
 */
public class 字符串最后一个单词的长度 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入字符串
        String str=sc.nextLine();
        String[] strs=str.split(" ");
        int len=strs[strs.length-1].length();
        System.out.println(len);
    }
}
