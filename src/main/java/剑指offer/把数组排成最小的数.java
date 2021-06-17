package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/16 下午7:38
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-16 19:38
 */
public class 把数组排成最小的数 {
    public String PrintMinNumber(int[] numbers) {
        if (numbers.length == 0) {
            return "";
        }
        quickSort(numbers, 0, numbers.length - 1);
        StringBuilder sb = new StringBuilder();

        for (int num : numbers) {
            sb.append(num);
        }

        return sb.toString();
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int stand = partion(nums, left, right);
        quickSort(nums, left, stand-1);
        quickSort(nums, stand + 1, right);
    }


    public int partion(int[] nums, int left, int right) {
        int index = left;
        int target = nums[left];

        while (left < right) {
            while (left < right && compareNum(target, nums[right]) <= 0) {
                right--;
            }
            while (left < right && compareNum(target, nums[left]) >= 0) {
                left++;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }

        swap(nums,left,index);
        return left;


    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public int compareNum(int num1, int num2) {
        //a+b>b+a则a>b
        String str1 = String.valueOf(num1);
        String str2 = String.valueOf(num2);
        return (str1 + str2).compareTo(str2 + str1);

    }
}
