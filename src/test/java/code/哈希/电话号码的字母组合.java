package code.哈希;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/2 下午5:15
 * @email: wangyuhang_mocas@163.com
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: AlgorithmCode
 * @description:
 * @author: mocas_wang
 * @create: 2021-05-02 17:15
 */
public class 电话号码的字母组合 {

    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return new LinkedList<>();
        }

        HashMap<Integer,String> map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        char[] words=digits.toCharArray();
        dfs(0,words,map);
        return res;

    }

    public void dfs(int index,char[] words,HashMap<Integer,String> map)
    {
        //终止条件
        if (index==words.length)
        {
            res.add(sb.toString());
            return;
        }
        //当前选择
        //数字
        int num=words[index]-'0';
        String str=map.get(num);
        //for 选择列表
        for (int i=0;i<str.length();i++)
        {
            //当前选择
            sb.append(str.charAt(i));
            //下一路径
            dfs(index+1,words,map);
            //恢复现场
            sb.deleteCharAt(sb.length()-1);
        }
    }

    @Test
    public void test()
    {
        List<String> res=letterCombinations("23");
        System.out.println(res);
    }

}
