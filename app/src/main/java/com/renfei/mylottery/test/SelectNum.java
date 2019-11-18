package com.renfei.mylottery.test;

import java.util.Comparator;

public class SelectNum  implements Comparator<SelectNum> {
    private String key;
    private int value;

    public SelectNum(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int compare(SelectNum o1, SelectNum o2) {
        return 0;
    }
}
