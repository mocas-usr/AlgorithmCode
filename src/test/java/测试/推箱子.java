package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/14 19:47
 * @email: wangyuhang_mocas@163.com
 */

import java.util.Scanner;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-07-14 19:47
 */
public class 推箱子 {
//    public static void main(String[] args) {
//        System.out.println(-1);
//    }

//    public static void main(String[] args) {
//        int i = count(new int[]{0, 1, 2, 3, 0, 2, 1, 2, 1});
//        System.out.println(i);
//    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while (sc.hasNextLine())
        {
            String[] str=sc.nextLine().trim().split(" ");
            int n=str.length;

            int[] nums=new int[n];
            for (int i=0;i<n;i++)
            {
                nums[i]=Integer.valueOf(str[i]);
            }

            int res=count(nums);
            System.out.println(res);

        }

    }
    public static int count(int[] positions){
        int count = 0;

        while (true) {
            int left = 0;
            while (left < positions.length) {
                if (positions[left] > 0) {
                    break;
                }
                left++;
            }
            if(left == positions.length) break;
            int right = left;
            while (right < positions.length) {
                if (positions[right] <= 0) {
                    break;
                }
                right++;
            }
            for (int i = left; i < right; i++) {
                positions[i] = positions[i] - 1;
            }
            count++;
        }
        return count;
    }
}
