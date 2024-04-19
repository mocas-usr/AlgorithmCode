package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/14 10:11
 * @email: wangyuhang_mocas@163.com
 */


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-14 10:11
 */
public class 去重 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String str=sc.nextLine().trim();
            List<Character> list=new LinkedList<>();
            char[] chars=str.toCharArray();

            for (char ch:chars)
            {
                if (!list.contains(ch))
                {
                    list.add(ch);
                }
            }

            for (char c:list)
            {
                System.out.print(c);
            }
        }
    }
}
