package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/16 下午8:21
 * @email: wangyuhang_mocas@163.com
 */

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-06-16 20:21
 */
public class 数组中的逆序对 {

    int count;

    //归并
    public int InversePairs(int[] array) {
        this.count = 0;
        merge(array, 0, array.length - 1);
        return count;
    }

    public void merge(int[] nums, int left, int right) {
        int mid = left+((right-left)>>1);
        if (left < right) {
            merge(nums, left, mid );
            merge(nums, mid + 1, right);
            mergeSort(nums, left, mid, right);
        }
    }

    public void mergeSort(int[] nums, int left, int mid, int right) {
        int[] temparr = new int[right - left + 1];
        int index = 0;
        int temp1 = left, temp2 = mid + 1;

        while (temp1 <= mid && temp2 <= right) {
            if (nums[temp1] <= nums[temp2]) {
                temparr[index++] = nums[temp1++];
            } else {
                //统计逆序
                count += (mid - temp1 + 1);
                count%=1000000007;
                temparr[index++] = nums[temp2++];
            }
        }
        //剩余的数组移动
        while (temp1 <= mid) {
            temparr[index++] = nums[temp1++];
        }
        while (temp2 <= right) {
            temparr[index++] = nums[temp2++];
        }

        //for旧数组移动到新的里面
        for (int k=0;k<temparr.length;k++)
        {
            nums[k+left]=temparr[k];
        }
    }
}
