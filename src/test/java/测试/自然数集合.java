package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/30 19:04
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Scanner;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-30 19:04
 */
public class 自然数集合 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        while (sc.hasNext())
        {
            int k=sc.nextInt();
            int n=sc.nextInt();
            String kStr=String.valueOf(k);
            int[] save = new int[30000];
            save[k] = 1;

            for (int i = 8; i < save.length; i++) {
                if (String.valueOf(i).contains(kStr) ) {
                    save[i] = save[i - 1] + 1;
                } else if (String.valueOf(i).contains(kStr)) {
                    save[i] = save[i - 1] + 1;
                }else {
                    save[i] = save[i - 1];
                }
            }
            System.out.println(save[n]);

//            String kStr=String.valueOf(k);
//            int index=0;
//            int res=0;
//            int i=0;
//            while (true)
//            {
//                String  str=String.valueOf(i);
//                int t=str.indexOf(kStr);
//                if (t==-1)
//                {
//                    index++;
//                }
//                if (index==n)
//                {
//                    res=i;
//                    break;
//                }
//                i++;
//
//            }
//            System.out.println(res);
        }
    }
}
