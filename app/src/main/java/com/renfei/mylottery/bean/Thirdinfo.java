package com.renfei.mylottery.bean;

import java.util.ArrayList;

public class Thirdinfo {
    private String openNums;
    private int openCount;
    private ArrayList<Integer> intervalList;

    public Thirdinfo() {
    }

    public Thirdinfo(String openNums, int openCount, ArrayList<Integer> intervalList) {
        this.openNums = openNums;
        this.openCount = openCount;
        this.intervalList = intervalList;
    }

    public String getOpenNums() {
        return openNums;
    }

    public void setOpenNums(String openNums) {
        this.openNums = openNums;
    }

    public int getOpenCount() {
        return openCount;
    }

    public void setOpenCount(int openCount) {
        this.openCount = openCount;
    }

    public ArrayList<Integer> getIntervalList() {
        return intervalList;
    }

    public void setIntervalList(ArrayList<Integer> intervalList) {
        this.intervalList = intervalList;
    }
}
