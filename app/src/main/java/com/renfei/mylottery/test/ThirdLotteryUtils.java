package com.renfei.mylottery.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;

public class ThirdLotteryUtils {

    public static LinkedHashSet<String> findAllCombinationNums() {
//        ArrayList<String> allNums = new ArrayList<>();


        LinkedHashSet<String> linkedNums = new LinkedHashSet<>();

        for (int i = 0; i < 10; i++) {
            String bai = String.valueOf(i);
            for (int j = 0; j < 10; j++) {
                String shi = String.valueOf(j);
                for (int k = 0; k < 10; k++) {
                    String ge = String.valueOf(k);
                    String result = bai + shi + ge;
                    linkedNums.add(sortString(result));
                }
            }
        }

        return linkedNums;
    }


    public static String sortString(String result) {
//
        //System.out.println("sortSting 启动");
        //将字符串进行分割，转成字符串数组


        ArrayList<String> sortList = new ArrayList<>();


        for (int i = 0; i < result.length(); i++) {
            sortList.add(String.valueOf(result.charAt(i)));
        }

        sortList.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return Integer.valueOf(s) - Integer.valueOf(t1);
            }
        });


        String data = "";

        for (int i = 0; i < sortList.size(); i++) {
            data += sortList.get(i);
        }

        return data;

    }

}
