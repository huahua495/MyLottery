package com.renfei.mylottery.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {






    public static class VersionBean {
        private String versionName;
        private String amount;

        public VersionBean(String versionName, String amount) {
            this.versionName = versionName;
            this.amount = amount;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "VersionBean{" +
                    "versionName='" + versionName + '\'' +
                    ", amount='" + amount + '\'' +
                    '}';
        }



    }


    public static void main(String[] args) {
        System.out.println("asdf");

        String path = "E:/手刷日志/08/08/";

        List<File> fileList = new ArrayList<>();


        List<String> verSionnameList = new ArrayList<>();

        verSionnameList.add("versionName|3.0.6");
        verSionnameList.add("versionName|3.0.7");
        verSionnameList.add("versionName|3.0.8");
        verSionnameList.add("versionName|3.0.9");
        verSionnameList.add("versionName|3.1.0");

        File file = new File(path);
        File[] files = file.listFiles();
        Arrays.sort(files);

        System.out.println(files.length + "    日志总文件数   ");
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                try {
                    InputStreamReader reader = null;

                    reader = new InputStreamReader(new FileInputStream(files[i]));

                    BufferedReader br = new BufferedReader(reader);
                    String line = "";
                    line = br.readLine();
                    bgm:
                    while (line != null) {
//                        System.out.println(files[i].getName() + ": " + line);
                        if (line.contains("versionName")) {
                            System.out.println("版本号    " + line);

                            if (!verSionnameList.contains(line)) {
                                fileList.add(files[i]);
                            }

                            break bgm;
                        }
                        line = br.readLine();
                    }
                    br.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        for (int i = 0; i < fileList.size(); i++) {

            fileList.get(i).delete();
        }
//        System.out.println(fileList.size()+"     非   ");
    }
}
