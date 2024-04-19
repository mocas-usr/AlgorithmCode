package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/8/1 15:44
 * @email: wangyuhang_mocas@163.com
 */


import java.text.NumberFormat;
import java.util.Scanner;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-08-01 15:44
 */
public class 滑动窗口 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        while (sc.hasNextLine())
        {
            String str=sc.nextLine().trim();
            String[] totalStr=str.split(":");
            String[] strNums=totalStr[0].split(",");
            int k= Integer.parseInt(totalStr[1]);
            int n=strNums.length;
            int[] nums=new int[n];
            for (int i=0;i<n;i++)
            {
                nums[i]=Integer.parseInt(strNums[i]);
            }
            //初始化窗口
            double presum=0;
           //初始化窗口
            for (int i = 0; i < k; i++) {

                presum+=nums[i];
            }

            double cursum=presum;
            double res=Double.MIN_VALUE;
            int left=0;
            int right=k;
            while (right<nums.length)
            {
                cursum+=nums[right];
                cursum-=nums[left];
                double temp=(cursum-presum)/presum;
                res=Math.max(temp,res);
                presum=cursum;
                right++;
                left++;
            }
            NumberFormat nt=NumberFormat.getPercentInstance();
            nt.setMinimumFractionDigits(2);
            System.out.println(nt.format(res));

//            System.out.println(res);


        }
    }

}
