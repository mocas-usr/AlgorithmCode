package code.分治;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/8 下午4:42
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-08 16:42
 */
public class 数组中的逆序对 {

    int count = 0;

    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        merge(nums, 0, nums.length - 1);

        return count;
    }

    public void merge(int[] nums, int left, int right) {

        int mid = left + (right - left) / 2;
        if (left >= right) {
            return;
        }
        //下一路径
        merge(nums, left, mid);
        //当前操作
        merge(nums, mid + 1, right);
        //当前操作
        mergeSort(nums, left, mid, right);

    }

    //两数组按照升序合并，假设已经有序
    public void mergeSort(int[] nums, int left, int mid, int right) {
        int a = left;
        int b = mid + 1;

        int[] temp = new int[right - left + 1];
        int index = 0;
        while (a <= mid && b <= right) {
            if (nums[a] <= nums[b]) {
                temp[index++] = nums[a++];
            } else {
                //如果后面的大于前面的则有
                count += mid - a + 1;
                temp[index++] = nums[b++];
            }
        }
        //处理剩余的数值
        while (a<=mid)
        {
            temp[index++]=nums[a++];
        }

        while (b<=right)
        {
            temp[index]=nums[b++];
        }
        //处理数组
        for (int i=0;i<temp.length;i++)
        {
            nums[left+i]=temp[i];
        }

    }

    @Test
    public void test()
    {
        int[] nums=new int[]{7,5,6,4};
        int res=reversePairs(nums);
        System.out.println(res);

    }
}
