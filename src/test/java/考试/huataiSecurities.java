package 考试;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/8/8 15:19
 * @email: wangyuhang_mocas@163.com
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-08-06 15:19
 */
public class huataiSecurities {


    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {2, 4, 1, 5, 6},
                {3, 2, 6, 5, 0}
        };

        int result = getMaxProfits(nums);
        System.out.println(result);
    }

    /**
     * int[i][j]
     * 输入i只股票的j天行情
     * 算出最大收益
     * 解题思路：
     * 1、存储所有股票单次最大收益，然后排序取前两名，和就是两次买不同股票的收益
     * 2、再存储同一只股票买两次的收益，然后排序取第一名，就是所有股票的单只两次的最大收益
     * 两次收益取最大值就是最大收入
     */
    public static int getMaxProfits(int[][] nums) {
        // 所有单只股票的最大收益
        List<Integer> singleMaxProfit = new ArrayList<>();
        // 单只股票两次的收益
        List<Integer> twoMaxProfits = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            maxProfits(nums[i], singleMaxProfit, twoMaxProfits);
        }

        singleMaxProfit.sort((o1, o2) -> o2 - o1);
        twoMaxProfits.sort((o1, o2) -> o2 - o1);
        // 从所有收益中取出排名前2的收益 就是两次购买不同股票最大收益了
        int f1 = singleMaxProfit.get(0) + singleMaxProfit.get(1);
        // 单只股票两次交易的最大值
        int f2 = twoMaxProfits.get(0);
        int result = Math.max(f1, f2);
        return result;
    }


    /**
     * @param prices          股票行情数组
     * @param singleMaxProfit 股票进行一次交易的最大利润list
     * @param twoMaxProfits   股票进行两次交易的最大利润list
     */
    public static void maxProfits(int[] prices, List<Integer> singleMaxProfit, List<Integer> twoMaxProfits) {

        int len = prices.length;

        /**初始化第0天的股票情况*/
        //买入这天的股票的利润
        int buy1 = -prices[0];
        //买入这天的股票后又卖出的利润
        int sell1 = 0;
        //买入这天的股票又卖出，然后再买入的利润
        int buy2 = -prices[0];
        //买入这天的股票又卖出，然后再买入又卖出的利润
        int sell2 = 0;
        /**********************/

        for (int i = 1; i < len; ++i) {

            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        //利润list加入变量
        singleMaxProfit.add(sell1);
        twoMaxProfits.add(sell2);
    }


    /**
     * 这种方法是暴力求解
     *
     * @param a 股票行情数组
     * @return 最大收益
     */
    public static int maxProfitsComplex(int[][] a) {
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

}
