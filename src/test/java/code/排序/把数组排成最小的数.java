package code.排序;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/11/5 下午6:11
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2020-11-05 18:11
 */
public class 把数组排成最小的数 {

    //插入排序
    public String minNumber(int[] nums) {
        //
        bubbleSort(nums);
        StringBuilder str = new StringBuilder();
        if (nums[0]==0)
        {
            return "0";
        }
        for (int num : nums) {
            str.append(num);
        }
        return str.toString();


    }

    //冒泡排序
    public void bubbleSort(int[] nums) {

        //外层控制冒泡的总个数，每排序一次确定一个最大数
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++)
                if (compare(nums[j], nums[j + 1]) > 0)
                {
                    swap(nums,j,j+1);

                }

        }
    }


    //快速排序
    public void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int stand = partion(nums, left, right);
        quickSort(nums, left, stand - 1);
        quickSort(nums, stand + 1, right);

    }

    //取标志位
    public int partion(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }

        int k = left;
        int temp = nums[left];

        while (left < right) {
            while (left < right && compare(nums[right], temp) >= 0) {
                right--;
            }
            while (left < right && compare(nums[left], temp) <= 0) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        //结束left==right
        swap(nums, left, k);
        return left;
    }

    //交换
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    //插入排序
    public void insertSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];//要排序的数值
            int j = i - 1;
            //插入排序，将需要排序的数值放入合适的位置
            while (j >= 0 && compare(temp, nums[j]) < 0)//如果temp<nums[j]
            {
                //将nums[j]后移动
                nums[j + 1] = nums[j];
                j--;
            }
            //移动结束之后，将temp插入位置
            nums[j + 1] = temp;
        }


    }

    //num1>num2,则返回1
    public int compare(int num1, int num2) {
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);
        return (str1 + str2).compareTo(str2 + str1);
    }

    @Test
    public void test() {
        int[] nums = {3, 30, 34, 5, 9};
        String res = minNumber(nums);
        System.out.println(res);
    }
}
