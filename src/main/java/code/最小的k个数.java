package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2020/10/20 下午4:23
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.Arrays;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2020-10-20 16:23
 */
public class 最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        //k个长度
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    //快速排序思想
    public int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        //快速排序
        return quickSort(arr, 0, arr.length - 1, k - 1);

    }

    //快速排序
    public int[] quickSort(int[] arr, int left, int right, int k) {

        //取标准
        int stand = getStand(arr, left, right);
        //如果相等，则stand左边的都比他小，加上自身，总共k个数值
        if (stand == k) {
            return Arrays.copyOf(arr, k + 1);
        } else if (stand > k) {
            return quickSort(arr, left, stand - 1, k);
        } else if (stand < k) {
            return quickSort(arr, stand + 1, right, k);
        }
        return null;

    }

    public int getStand(int[] arr, int left, int right) {
        //定义指针
        int i = left;
        int j = right;
        //定位的数值
        int temp = arr[left];
        //
        while (i < j) {
            //找到不符合条件的左右数值
            while (temp <= arr[j] && i < j) {
                j--;
            }
            while (temp >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                swap(arr, i, j);
            }

        }
        //最后得到结果i=j
        swap(arr, left, i);
        return i;
    }

    //交换
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //计数排序
    public int[] getLeastNumbers3(int[] arr, int k)
    {
        if (k==0 ||arr.length==0)
        {
            return new int[0];
        }

        //统计每个字符出现的次数
        int[] count=new int[10001];
        for (int num:arr)
        {
            count[num]++;
        }

        int index=0;
        int[] res=new int[k];//结果集存放
        //计数之后开始分配
        for (int i=0;i<10001;i++)
        {
            while (count[i]>0 &&index<k)
            {
                res[index++]=i;
                count[i]--;
            }
        }

        return res;

    }

    @Test
    public void test()
    {
        int[] nums={3,2,1};
        int k = 2;
        int[] res=getLeastNumbers3(nums,k);
        System.out.println(Arrays.toString(res));
    }
}
