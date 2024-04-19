package 测试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/7/25 19:39
 * @email: wangyuhang_mocas@163.com
 */

import code.topK.数据流中的第K大元素;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-07-25 19:39
 */
public class 数字乘积 {


    //全局变量
   public static List<List<Integer>> res = new LinkedList<>();
   public static List<Integer> list = new LinkedList<>();
    public static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {

            for (int i = 0; i < 10; i++) {
                int num = sc.nextInt();
                //添加num个i
                for (int j = 0; j < num; j++) {
                    list.add(i);
                }
            }
            //数字共有多少种组合
            dfs(0);
            int minmax=0;
            //遍历所有数值
            for (int i = 0; i < res.size(); i++) {
                List<Integer> strNum = res.get(i);
                StringBuilder sb = new StringBuilder();
                for (int t : strNum) {
                    sb.append(t);
                }
                int sbnum=Integer.parseInt(sb.toString());
                if (sbnum>minmax)
                {
                    minmax=sbnum;
                    getMaxNum(sb.toString());
                }


            }
            System.out.println(max);




        }
    }

    public static void getMaxNum(String strNum) {

        int n=strNum.length();
        int ans=0;
        for (int i=1;i<n;i++)
        {
            String s1=strNum.substring(0,i);
            String s2=strNum.substring(i,n);
            int num1=Integer.parseInt(s1);
            int num2=Integer.parseInt(s2);

            ans=num1*num2;
            max=Math.max(max,ans);
        }

    }

    public static List<List<Integer>> getResNum(int[] nums) {

        //特殊处理
        if (nums.length == 0) {
            return null;
        }
        //利用集合
        for (int num : nums) {
            list.add(num);
        }

        //起始路径
        dfs(0);
        return res;

    }

    //回溯
    public static void dfs(int index) {
        //终止条件
        if (index == list.size()) {
            if (!res.contains(list))
            {
                res.add(new LinkedList<>(list));
            }
            return;
        }
        //剪枝

        //for 选择列表
        //只跟自己右边的数值交换
        for (int i = index; i < list.size(); i++) {
            //做选择
            swap(i, index);//index这一位上的选择，进行交换
            //下一路径
            dfs(index + 1);
            //恢复现场
            swap(i, index);
        }
    }

    public static void swap(int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
