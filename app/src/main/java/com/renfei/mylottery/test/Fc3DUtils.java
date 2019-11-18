package com.renfei.mylottery.test;

import java.util.ArrayList;

public class Fc3DUtils {
    public static String[] numberArr = new String[1000];

    public static final int MAX_NUMBER = 10;

    private ArrayList<String> allNums;

    public Fc3DUtils() {
        allNums = new ArrayList<>();
        initNumberArr();
    }


    public ArrayList<String> getAllNums() {
        return allNums;
    }

    public void setAllNums(ArrayList<String> allNums) {
        this.allNums = allNums;
    }

    private void initNumberArr() {
        String bai;
        String shi;
        String ge;


        for (int i = 0; i < MAX_NUMBER; i++) {
            bai = String.valueOf(i);
            for (int j = 0; j < MAX_NUMBER; j++) {
                shi = String.valueOf(j);

                for (int k = 0; k < MAX_NUMBER; k++) {
                    ge = String.valueOf(k);
                    allNums.add(bai + shi + ge);
                }
            }
        }

    }

    /**
     * 过滤数字
     *
     * @param params
     * @return
     */
    private ArrayList<String> remove(String params) {
        ArrayList<String> mList = new ArrayList<>();


        for (int i = 0; i < allNums.size(); i++) {
            String parent = allNums.get(i);
            if (!parent.contains(params)) {
                if (!mList.contains(parent)) {
                    mList.add(parent);
                }
            }

        }

        for (int i = 0; i < mList.size(); i++) {
            System.out.println(mList.get(i));
        }
        System.out.println("选择的号码数量    " + mList.size());
        return mList;
    }


    private ArrayList<String> isContainer(String[] params) {
        ArrayList<String> mList = new ArrayList<>();


        for (int i = 0; i < allNums.size(); i++) {
            String parent = allNums.get(i);

            for (int j = 0; j < params.length; j++) {
                if (parent.contains(String.valueOf(params[j]))) {
                    if (!mList.contains(parent)) {
                        mList.add(parent);
                    }
                }
            }

        }


        for (int i = 0; i < mList.size(); i++) {
            System.out.println(mList.get(i));
        }
        System.out.println("选择的号码数量    " + mList.size());
        return mList;
    }

}
