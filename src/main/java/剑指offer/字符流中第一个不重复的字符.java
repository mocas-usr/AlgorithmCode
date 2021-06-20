package 剑指offer;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/6/17 下午2:47
 * @email: wangyuhang_mocas@163.com
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-06-17 14:47
 */
public class 字符流中第一个不重复的字符 {

    int[] count=new int[128];
    Queue<Character> queue=new LinkedList<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (count[ch]==0)
        {
            queue.add(ch);
        }else
        {
            //可以直接定位删除
            queue.remove(new Character(ch));
        }
        count[ch]++;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        if (!queue.isEmpty())
        {
            return queue.peek();
        }else
        {
            return '#';
        }
    }

//    public void Insert(char ch)
//    {
//
//    }
//    //return the first appearence once char in current stringstream
//    public char FirstAppearingOnce()
//    {
//
//    }
}
