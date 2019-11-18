package com.renfei.mylottery.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 号码去除重复
 */
public class NumberDeduplication {

    public static boolean isEmpty(String... strings) {
        for (String str : strings) {
            if (str == null || str.trim().length() == 0)
                return true;
        }
        return false;
    }

    public static String orderBy(String str) {
        if (isEmpty(str)) {
            return "";
        }
        char[] array = str.toCharArray();

        Arrays.sort(array);
        String result = new String(array);
        return result;
    }


    public static void main(String[] args) {


        ArrayList<String> resultData = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入所有大底");

        ArrayList<String> allList = getResultList(scanner.nextLine());

        /**
         * allList去除重复号码
         */
        Set<String> setList = numberDeduplication(allList);


        while (true) {
            Scanner scannerTarget = new Scanner(System.in);
            System.out.println("请输入需要过滤的号码");
            ArrayList<String> targetList = getResultList(scannerTarget.nextLine());

            for (int i = 0; i < targetList.size(); i++) {
                if (!setList.contains(targetList.get(i))) {
                    setList.add(targetList.get(i));
                }
            }
            for (String str : setList) {
                System.out.print(str + ",");

            }
            System.out.println(" ");
        }


    }

    public static Set<String> numberDeduplication(List<String> list) {
        Object[] objects = list.toArray();// 返回Object数组
        String[] strings1 = new String[list.size()];
        list.toArray(strings1);// 将转化后的数组放入已经创建好的对象中
        String[] strings2 = list.toArray(new String[0]);// 将转化后的数组赋给新对象
        Set<String> set = new HashSet<String>(Arrays.asList(strings2));
        return set;
    }


    public static ArrayList<String> getResultList(String str) {
        ArrayList<String> mList = new ArrayList<>();

        String[] targetArray = str.split(",");

        for (int i = 0; i < targetArray.length; i++) {
            mList.add(orderBy(targetArray[i]));
        }
        return mList;
    }


    static class MyComparator implements Comparator<Map.Entry> {
        @Override
        public int compare(Map.Entry o1, Map.Entry o2) {
            return ((Integer) o2.getValue()).compareTo((Integer) o1.getValue());
        }
    }

}
