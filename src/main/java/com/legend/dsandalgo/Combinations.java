package com.legend.dsandalgo;

import com.alibaba.fastjson.JSON;
import com.legend.dsandalgo.utils.StringUtils;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {

    public static List<String> permutations1(List<String[]> list, String[] headList, String str) {
        List<String> retList = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            //取得当前的数组
            if (i == list.indexOf(headList)) {
                //迭代数组
                for (String st : headList) {
                    st = st + str;
                    if (i < list.size() - 1) {
                        //st = str + st;
                        System.out.println(st);
                        List<String> tmpList = permutations1(list, list.get(i + 1), st);
                        retList.addAll(tmpList);
                    } else if (i == list.size() - 1) {
                        st = StringUtils.strip(st, ",");
                        st = "[" + st + "]";
                        retList.add(st);
                        //System.out.println(st);
                    }
                }
            }
        }
        return retList;
    }

    public static void main (String [] args) {
        String[] arr1 = {"甜", "不甜"};
        String[] arr2 = {"微辣", "中辣", "超辣"};
        String[] arr3 = {"小份", "中份", "大份", "超大份"};

        List<String[]> list = new ArrayList<>();
        list.add(arr3);
        list.add(arr2);
        list.add(arr1);
        //用, 将每个组合值分开
        for (int i=0,len=list.size(); i<len; i++) {
            List<String> tmpList = new LinkedList<>();
            for (String s : list.get(i)) {
                tmpList.add(s + ",");
            }
            list.set(i, tmpList.toArray(new String[tmpList.size()]));
        }
        System.out.println(JSON.toJSONString(list));

        List retList = permutations1(list, list.get(0), "");
        System.out.println(retList.size());
        System.out.println(JSON.toJSONString(retList));
    }
}
