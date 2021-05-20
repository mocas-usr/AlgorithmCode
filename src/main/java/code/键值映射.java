package code;/**
 * Created with IntelliJ IDEA
 *
 * @Author: mocas
 * @Date: 2021/5/17 下午9:27
 * @email: wangyuhang_mocas@163.com
 */

/**
 *@program: AlgorithmCode
 *@description:
 *@author: mocas_wang
 *@create: 2021-05-17 21:27
 */
public class 键值映射 {
    class MapSum {
        //定义节点结构
         class TrieNode{
            int val;
            TrieNode[] children = new TrieNode[26];
        }

        TrieNode root;

        /** Initialize your data structure here. */
        public MapSum() {
            root=new TrieNode();

        }

        public void insert(String key, int val) {
                TrieNode node=root;

                for (int i=0;i<key.length();i++)
                {
                    int ch=key.charAt(i)-'a';
                    if (node.children[ch]==null)
                    {
                        node.children[ch]=new TrieNode();
                    }
                    node=node.children[ch];
                }
                node.val=val;
        }

        public int sum(String prefix) {
                int res=0;
                TrieNode node=root;
                for (int i=0;i<prefix.length();i++)
                {
                    char ch=prefix.charAt(i);
                    int index=ch-'a';
                    if (node.children[index]==null)
                    {
                        return 0;
                    }
                    node=node.children[index];
                }
                //这个node是prex最后一个字符
                return dfs(node);
        }

        public int dfs(TrieNode node)
        {
            if (node==null)
            {
                return 0;
            }
            int res=0;

            //for循环列表
            for (int i=0;i<26;i++)
            {
                //当前路径
                if (node.children[i]!=null)
                {
                    //下一路径
                    res+=dfs(node.children[i]);
                }

            }
            return res+node.val;
        }
    }
}
