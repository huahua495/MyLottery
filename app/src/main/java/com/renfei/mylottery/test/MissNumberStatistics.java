package com.renfei.mylottery.test;

import android.annotation.TargetApi;
import android.os.Build;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 遗漏号码统计
 * <p>
 * 项目	周期	出现次数	理论出现次数	出现频率	平均遗漏	最大遗漏	上次遗漏	本次遗漏	欲出几率	投资价值
 */
public class MissNumberStatistics {

    @TargetApi(Build.VERSION_CODES.N)
    public static void main(String[] args) {

        InputStreamReader isr = null;

        String fileName = "C:\\Users\\77873\\Desktop\\other\\012路.txt";
        try {//try代码块，当发生异常时会转到catch代码块中
            //读取指定的文件
//            isr = new InputStreamReader(new FileInputStream("G:/io/ISO-8859-1.txt"));


            FileInputStream fileInputStream = new FileInputStream(fileName);

            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");

            BufferedReader in = new BufferedReader(inputStreamReader);
            String str = null;//定义一个字符串类型变量str

            ArrayList<MissNumber> missNumberList = new ArrayList<>();

            ArrayList<Map<String, String>> mapList = new ArrayList<>();


            while ((str = in.readLine()) != null) {//readLine()方法, 用于读取一行,只要读取内容不为空就一直执行

                String[] array = str.split("\t");


                MissNumber bean = new MissNumber();
                bean.setNumber(array[0]);
                bean.setCycle(array[1]);
                bean.setChuxiancishu(array[2]);
                bean.setLilun_cishu(array[3]);
                bean.setChuxian_pinlv(array[4]);
                bean.setAverage(array[5]);
                bean.setMax(array[6]);
                bean.setLast(array[7]);
                bean.setCurrent(array[8]);
                bean.setRemark1(array[9]);
                bean.setRemark2(array[10]);
                missNumberList.add(bean);
            }


            missNumberList.sort(new Comparator<MissNumber>() {
                @Override
                public int compare(MissNumber o1, MissNumber o2) {

                    return Integer.valueOf(o2.getChuxiancishu()) - Integer.valueOf(o1.getChuxiancishu());
                }
            });

            for (int i = 0; i < missNumberList.size(); i++) {
                MissNumber bean = missNumberList.get(i);
                Map<String, String> map = new HashMap<>();
                map.put("number", bean.getNumber());
                map.put("amount", bean.getChuxiancishu());
                mapList.add(map);
            }


            for (int i = 0; i < mapList.size(); i++) {
                Map<String, String> map = mapList.get(i);

                System.out.println(map.get("number") + "      " + map.get("amount"));
            }


        } catch (IOException e) {//当try代码块有异常时转到catch代码块
            e.printStackTrace();//printStackTrace()方法是打印异常信息在程序中出错的位置及原因
        }
    }

}
