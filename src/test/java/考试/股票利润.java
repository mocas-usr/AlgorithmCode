package 考试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/8/5 17:03
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-08-05 17:03
 */
public class 股票利润 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] nums = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    nums[i][j] = sc.nextInt();
                }
            }
            // 所有单只股票的最大收益
            List<Integer> profits = new ArrayList<>();
            // 单只股票两次的收益
            List<Integer> singleTwoProfits = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                //求单只股票的收益
                maxProfits(nums[i], profits, singleTwoProfits);
            }
            // 从所有收益中取出排名前2的收益 就是两次购买不同股票最大收益了
            profits.sort((o1, o2) -> o2 - o1);
            singleTwoProfits.sort((o1, o2) -> o2 - o1);
            int f1 = profits.get(0) + profits.get(1);
            int f2 = singleTwoProfits.get(0);
            int result = Math.max(f1, f2);
            System.out.println(result);

        }
    }

    @Test
    public void test() {
        int[][] nums = new int[][]{
                {2, 4, 1, 5, 6},
                {1, 2, 2, 2, 2},
                {1, 2, 2, 2, 2, 7}
        };
        // 所有单只股票的最大收益
        List<Integer> singleMaxProfit = new ArrayList<>();
        // 单只股票两次的收益
        List<Integer> twoMaxProfits = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //求单只股票的收益
            maxProfits(nums[i], singleMaxProfit, twoMaxProfits);
        }
        // 从所有收益中取出排名前2的收益 就是两次购买不同股票最大收益了
        singleMaxProfit.sort((o1, o2) -> o2 - o1);
        twoMaxProfits.sort((o1, o2) -> o2 - o1);
        int f1 = singleMaxProfit.get(0) + singleMaxProfit.get(1);
        int f2 = twoMaxProfits.get(0);
        int result = Math.max(f1, f2);
        System.out.println(result);
    }

    public static void maxProfits(int[] prices, List<Integer> profits, List<Integer> singleTwoProfits) {

        int len = prices.length;
        //最多可以完成两笔交易
        int buy1 = -prices[0];//第0天买入这天的股票的利润
        int sell1 = 0;//第0天买入这天的股票后又卖出的利润
        int buy2 = -prices[0];//第0天买入这天的股票又卖出，然后再买入的利润
        int sell2 = 0;//第0天买入这天的股票又卖出，然后再买入又卖出的利润
        for (int i = 1; i < len; ++i) {
            //第i天结束时的状态下，利润要么是第i-1天时的利润（第i-1天买入了，第i天啥也不干），要么是
            //第i天买入股票后的利润（第i-1天没有买入，第i天才买入）
            buy1 = Math.max(buy1, -prices[i]);
            //第i天结束时的状态下（此前肯定已经买入过一次了），利润要么是第i-1天时的利润
            //（第i-1天买入又卖出了，第i天啥也不干），要么是
            //第i天卖出股票后的利润（前面已经买入过一次，第i天卖出）
            sell1 = Math.max(sell1, buy1 + prices[i]);
            //第i天结束时的状态下，利润要么是第i-1天时的利润（此前已经买入卖出过一次，第i天啥也不干），
            //要么是第i天买入股票后的利润（此前买入卖出过一次，第i天再次买入）
            buy2 = Math.max(buy2, sell1 - prices[i]);
            //第i天结束时的状态下（此前肯定已经买入卖出过一次了），利润要么是第i-1天时的利润
            //（第i-1天第二次买入，第i天啥也不干），要么是
            //第i天卖出股票后的利润（前面已经买入过一次，第i天卖出）
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        //最大利润，根据表达式，最大利润要么是sell1要么是sell2，而sell1必然是小于等于sell2的
        profits.add(sell1);
        singleTwoProfits.add(sell2);

    }

    /**
     * int[i][j]
     * 输入i只股票的j天行情
     * 算出最大收益
     * 解题思路：
     * 1、存储所有股票单次最大收益，然后排序取前两名，和就是两次买不同股票的收益
     * 2、再存储同一只股票买两次的收益，然后排序取第一名，就是所有股票的单只两次的最大收益
     * 两次收益取最大值就是最大收入
     *
     * @param a 股票行情数组
     * @return 最大收益
     */
    public static int maxProfits(int[][] a) {
        // 所有单只股票的最大收益
        List<Integer> profits = new ArrayList<>();
        // 单只股票两次的收益
        List<Integer> singleTwoProfits = new ArrayList<>();
        // 获取到每只股票
        for (int[] ints : a) {
            // 对每只股票的单次收益进行收集
            List<Integer> singleProfits = new ArrayList<>();
            // 这只股票的两次收益
            List<Integer> thisTwoProfits = new ArrayList<>();
            // 买入日
            for (int i = 0; i < ints.length; i++) {
                // 卖出日
                for (int j = i + 1; j < ints.length; j++) {
                    // 本次卖出收益 也是第一次卖出的收益
                    int profit = ints[j] - ints[i];
                    singleProfits.add(profit);
                    // 卖出日之后的时间
                    // 收集所有可能的第二次卖出的收益
                    List<Integer> secondProfits = new ArrayList<>();
                    for (int k = j + 1; k < ints.length; k++) {
                        for (int l = k + 1; l < ints.length; l++) {
                            int secondProfit = ints[l] - ints[k];
                            secondProfits.add(secondProfit);
                        }
                    }
                    // 如果第二次的收益不是空
                    if (!secondProfits.isEmpty()) {
                        secondProfits.sort((o1, o2) -> o2 - o1);
                        // 存储单只股票的两次收益
                        thisTwoProfits.add(profit + secondProfits.get(0));
                    }
                }
            }
            // 对本次股票的两次收益进行倒序排序
            thisTwoProfits.sort((o1, o2) -> o2 - o1);
            // 存储这只股票两次收益的最大值
            singleTwoProfits.add(thisTwoProfits.get(0));
            // 对单只股票收益进行倒序排序
            singleProfits.sort((o1, o2) -> o2 - o1);
            // 保存单次最大收益
            profits.add(singleProfits.get(0));
        }
        // 从所有收益中取出排名前2的收益 就是两次购买不同股票最大收益了
        profits.sort((o1, o2) -> o2 - o1);
        singleTwoProfits.sort((o1, o2) -> o2 - o1);
        int f1 = profits.get(0) + profits.get(1);
        int f2 = singleTwoProfits.get(0);
        return Math.max(f1, f2);
    }

    //这个时候貌似别的方法就很复杂了，用动态规划
    public int maxProfit(int[] prices) {
        int len = prices.length;
        //最多可以完成两笔交易
        int buy1 = -prices[0];//第0天买入这天的股票的利润
        int sell1 = 0;//第0天买入这天的股票后又卖出的利润
        int buy2 = -prices[0];//第0天买入这天的股票又卖出，然后再买入的利润
        int sell2 = 0;//第0天买入这天的股票又卖出，然后再买入又卖出的利润
        for (int i = 1; i < len; ++i) {
            //第i天结束时的状态下，利润要么是第i-1天时的利润（第i-1天买入了，第i天啥也不干），要么是
            //第i天买入股票后的利润（第i-1天没有买入，第i天才买入）
            buy1 = Math.max(buy1, -prices[i]);
            //第i天结束时的状态下（此前肯定已经买入过一次了），利润要么是第i-1天时的利润
            //（第i-1天买入又卖出了，第i天啥也不干），要么是
            //第i天卖出股票后的利润（前面已经买入过一次，第i天卖出）
            sell1 = Math.max(sell1, buy1 + prices[i]);
            //第i天结束时的状态下，利润要么是第i-1天时的利润（此前已经买入卖出过一次，第i天啥也不干），
            //要么是第i天买入股票后的利润（此前买入卖出过一次，第i天再次买入）
            buy2 = Math.max(buy2, sell1 - prices[i]);
            //第i天结束时的状态下（此前肯定已经买入卖出过一次了），利润要么是第i-1天时的利润
            //（第i-1天第二次买入，第i天啥也不干），要么是
            //第i天卖出股票后的利润（前面已经买入过一次，第i天卖出）
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        //最大利润，根据表达式，最大利润要么是sell1要么是sell2，而sell1必然是小于等于sell2的
        return sell2;
    }


}
