package com.renfei.mylottery.test;


import com.renfei.mylottery.bean.Thirdinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;

public class History3DLottery {

    public static void main(String[] args) {


        File file = new File("D:/WorkSpace/DemoProject/MyLottery/app/src/main/java/com/renfei/mylottery/test/3D.txt");

        if (file.isFile() && file.exists()) {

            LinkedList<Model3D> mList = new LinkedList<>();


            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


                String line = "";

                while ((line = bufferedReader.readLine()) != null) {

                    if (!isEmpty(line)) {
                        String[] current = line.split(" ");
                        mList.add(new Model3D(current[0], current[1], current[2] + current[3] + current[4]));
                    }
                }

                mList.sort(new Comparator<Model3D>() {
                    @Override
                    public int compare(Model3D model3D, Model3D t1) {
                        return Integer.valueOf(model3D.getDateLine()) - Integer.valueOf(t1.getDateLine());
                    }
                });

              /*  for (Model3D model : mList) {
                    System.out.println(model.toString());
                }*/


                /**
                 * 所有的组选号码,包括豹子号码
                 */
                LinkedHashSet<String> allList = ThirdLotteryUtils.findAllCombinationNums();

                ArrayList<Thirdinfo> thirdinfoList = new ArrayList<>();

                for (String targetStr : allList) {
                    Thirdinfo info = new Thirdinfo();
                    ArrayList<Integer> interval = new ArrayList<>();

                    int count = 0;
                    for (int i = 0; i < mList.size(); i++) {
                        String currentStr = ThirdLotteryUtils.sortString(mList.get(i).getOpenNums());
                        if (targetStr.equals(currentStr)) {
                            count += 1;
                            interval.add(i);
                        }
                    }
                    info.setIntervalList(interval);
                    info.setOpenCount(count);
                    info.setOpenNums(targetStr);
                    thirdinfoList.add(info);
                }

                Collections.sort(thirdinfoList, new Comparator<Thirdinfo>() {
                    @Override
                    public int compare(Thirdinfo thirdinfo, Thirdinfo t1) {
                        return t1.getOpenCount() - thirdinfo.getOpenCount();
                    }
                });


                for (int i = 0; i < thirdinfoList.size(); i++) {
                    Thirdinfo thirdinfo = thirdinfoList.get(i);

                    System.out.println(thirdinfo.getOpenNums() + "-" + thirdinfo.getOpenCount());

                    ArrayList<Integer> integerArrayList = thirdinfo.getIntervalList();
                    for (int j = 0; j < integerArrayList.size(); j++) {
                        if (j == 0) {
                            System.out.print(0 + "  ");
                        } else {
                            System.out.print((integerArrayList.get(j) - integerArrayList.get(j - 1)) + "  ");
                        }
                    }

                    System.out.println("-------------------");
                }


//                System.out.println("总共的期数   " + mList.size());

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件不存在");
        }


    }


    public static boolean isEmpty(String... strings) {
        for (String str : strings) {
            if (str == null || str.trim().length() == 0)
                return true;
        }
        return false;
    }
}
