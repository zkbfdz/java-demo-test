package Test;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * Created by kai.zhu on 2018/4/11/011.
 */
public class Demo {


    public static void main(String[] args) {
        String s = "{\"openId\":\"11\",\"roleId\":\"10001\"}";
        Bean1 bean1 = JSON.parseObject(s, Bean1.class);
        System.out.println(bean1);
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length==0 || in.length==0) {
            return null;
        }
        TreeNode node = new TreeNode(pre[0]);
        for(int i = 0; i < in.length; i++) {
            if(pre[0] == in[i]) {
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i+1), Arrays.copyOfRange(in, 0, i));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i+1, pre.length), Arrays.copyOfRange(in, i+1, in.length));
            }
        }

        return node;
    }


}
